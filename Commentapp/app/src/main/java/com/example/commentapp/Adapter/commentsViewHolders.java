package com.example.commentapp.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.commentapp.R;

import org.w3c.dom.Comment;

class commentsViewHolders extends RecyclerView.ViewHolder {

    public commentsViewHolders(@NonNull View itemView) {
        super(itemView);
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {

        private final ImageView avatarImageView;
        private final ExpandableTextView commentTextView;
        private final TextView dateTextView;
        private final ProfileManager profileManager;
        private CommentsAdapter.Callback callback;
        private Context context;

        public CommentViewHolder(View itemView, final CommentsAdapter.Callback callback) {
            super(itemView);

            this.callback = callback;
            this.context = itemView.getContext();
            profileManager = ProfileManager.getInstance(itemView.getContext().getApplicationContext());

            avatarImageView = (ImageView) itemView.findViewById(R.id.avatarImageView);
            commentTextView = (ExpandableTextView) itemView.findViewById(R.id.commentText);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);

            if (callback != null) {
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            callback.onLongItemClick(v, position);
                            return true;
                        }

                        return false;
                    }
                });
            }
        }

        public void bindData(Comment comment) {
            final String authorId = comment.getAuthorId();

            if (authorId != null) {
                profileManager.getProfileSingleValue(authorId, createOnProfileChangeListener(commentTextView,
                        avatarImageView, comment, dateTextView));
            } else {
                fillComment("", comment, commentTextView, dateTextView);
            }

            avatarImageView.setOnClickListener(v -> callback.onAuthorClick(authorId, v));
        }

        private OnObjectChangedListener<ContactsContract.Profile> createOnProfileChangeListener(final ExpandableTextView expandableTextView,
                                                                                                final ImageView avatarImageView,
                                                                                                final Comment comment,
                                                                                                final TextView dateTextView) {
            return new OnObjectChangedListener<Profile>() {
                @Override
                public void onObjectChanged(Profile obj) {
                    if (obj != null) {
                        String userName = obj.getUsername();
                        fillComment(userName, comment, expandableTextView, dateTextView);

                        if (obj.getPhotoUrl() != null) {
                            ImageUtil.loadImage(GlideApp.with(context), obj.getPhotoUrl(), avatarImageView);
                        }
                    }
                }

                @Override
                public void onError(String errorText) {
                    fillComment("", comment, commentTextView, dateTextView);
                }
            };
        }

        private void fillComment(String userName, Comment comment, ExpandableTextView commentTextView, TextView dateTextView) {
            Spannable contentString = new SpannableStringBuilder(userName + "   " + comment.getText());
            contentString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.highlight_text)),
                    0, userName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            commentTextView.setText(contentString);

            CharSequence date = FormatterUtil.getRelativeTimeSpanString(context, comment.getCreatedDate());
            dateTextView.setText(date);
        }




}
