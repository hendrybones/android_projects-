package com.example.products;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView profileImageView = (ImageView) findViewById(R.id.profileImageView);
        TextView userNameTextView = (TextView) findViewById(R.id.usernameTextView);
        TextView developerUrl = (TextView) findViewById(R.id.developerUrl);
        ImageButton shareProfile = (ImageButton) findViewById(R.id.shareProfile);


// TODO: 5.1.2 Use Picasso to display it on the imageView of the profile page.
        Intent intent = getIntent();
        final String userName = intent.getStringExtra(DevelopersAdapter.KEY_NAME);
        String image = intent.getStringExtra(DevelopersAdapter.KEY_IMAGE);
        final String profileUrl = intent.getStringExtra(DevelopersAdapter.KEY_URL);

        // Recall we’ve set the id’s of the TextView in the ProfileActivity layout file to userNameTextView and developerUrl.
        // TODO: 5.1.3 Set the Texts on them whilst displaying the image on the profileImageView with Picasso.
        Picasso.get()
                .load(image)
                .into(profileImageView);

        userNameTextView.setText(userName);
        developerUrl.setText(profileUrl);

// TODO: 5.2 Handling OnItem Clicks
        // We want to launch the browser to load the developers github profile page upon clicking the developerUrl on the profile page
        developerUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = profileUrl;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        // TODO: 5.3 Final share button functionality

        /** we want for the app is to have a button in the Profile page that will share the contents of the profile page via other
         * social media apps, so we’ll define the intent to handle this with an onClickListener on the button. **/
        shareProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer " + userName +
                        ", " + profileUrl);
                Intent chooser = Intent.createChooser(shareIntent, "Share via");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });






    }
}
