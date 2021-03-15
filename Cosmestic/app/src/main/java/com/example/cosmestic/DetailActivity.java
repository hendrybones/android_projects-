package com.example.cosmestic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView profileImageView = (ImageView) findViewById(R.id.profileImageView);
        TextView userNameTextView = (TextView) findViewById(R.id.usernameTextView);
        ImageButton shareProfile = (ImageButton) findViewById(R.id.shareProfile);
        TextView developerUrl = (TextView) findViewById(R.id.developerUrl);


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
    }
}
