package com.example.products;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {
    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    // We define a list from the DevelopersList java class
    private List<DevelopersList> developersLists;
    private Context context;

    public DevelopersAdapter(List<DevelopersList> developersLists, Context context) {

        // generate constructors to initialise the List and Context objects

        this.developersLists = developersLists;
        this.context = context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this method will be called whenever our ViewHolder is created
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.developers_list, parent, false);
        return new ViewHolder(v);

    }
    //TODO: 3.1.3 Here we inflate the layout to the developers_list and it returns a new ViewHolder(v)

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
      //this method will bind the data to the ViewHolder from whence it'll be shown to other Views
        final DevelopersList developersList = developersLists.get(position);
        holder.login.setText(developersList.getLogin());

        /** Notice how we used Picasso to load the image data from the developersList to the ViewHolder. **/
        Picasso.get()
                .load(developersList.getAvatar_url())
                .into(holder.avatar_url);
        /** We’ll set an OnClickListener on the linear layout holding the CardViews so that upon clicking any card on the
         * RecyclerView, it’ll open the profile page of the developer on that card with an Intent. **/
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DevelopersList developersList1 = developersLists.get(position);
                Intent skipIntent = new Intent(v.getContext(), DetailsActivity.class);
                skipIntent.putExtra(KEY_NAME, developersList1.getLogin());
                skipIntent.putExtra(KEY_IMAGE, developersList1.getAvatar_url());
                /** To open the ProfileActivity we create an Intent (in this context) which I called skipIntent and put the values
                 *  into the static variables.**/
                v.getContext().startActivity(skipIntent);
            }
        });

    }
    // TODO: 3.1.4 getItemCount
    @Override
    public int getItemCount() {
        return developersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView login;
        public ImageView avatar_url;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // TODO: 3.1.6 Initialize the View objects 'itemView'
            login = (TextView) itemView.findViewById(R.id.username);
            avatar_url = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
    // TODO: 4... Next we setup the adapter class in the MainActivity
}
