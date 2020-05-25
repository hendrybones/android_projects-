package com.example.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    // TODO: 4.0.0 After 1: setting DevelopersList and 2: Developers Adapter,

    /** We initialize it globally | private RecyclerView.Adapter adapter;
     * we also do the same for our DevelopersList class | private List<DevelopersList> developerslists |
     * then in the onCreate() we do; developersLists = new ArrayList<>(); **/
    private RecyclerView.Adapter adapter;

    // TODO: 4.1.0 Fetching the remote json data. String variable for the api private 'static final String URL_DATA = “api-url here”'.
    // Then create loadUrlData() method.
    private static final String URL_DATA = "https://api.github.com/search/users?q=language:java+location:lagos";

    private List<DevelopersList> developersLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /** This list will hold the contents of our remote JSON and pass it to the recyclerview. **/
        developersLists = new ArrayList<>();

        loadUrlData();
    }
    private void loadUrlData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        /**
         * Start by using StringRequest (From the volley dependency) to define the request and RequestQueue to then send the request.
         * We then create an instance of the DevelopersList to store the individual objects we’ll be getting from the items Array.**/
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                // Once the request is sent, we need to display a progress dialog to keep the user engaged while the task is performed.
                progressDialog.dismiss();

                // TODO: 4.1.2 Create a new JSONObject and pass in (response) as a parameter, then surround it with (try and catch) to
                //  catch all the possible exceptions.
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    /** define a JSONArray from the jsonObject we just created, this is to enable us gain access to the “items” array
                     *  inside the jsonObject thus we’ll pass in “items” as a parameter. **/
                    JSONArray array = jsonObject.getJSONArray("items");

                    // This will get the data from the array according to their index.
                    for (int i = 0; i < array.length(); i++){

                        // JSONObject that will allow us get data from the array according to the current index.
                        JSONObject jo = array.getJSONObject(i);

                        /** DevelopersList object called developers and pass in the data we’ll be getting from the jsonObject(jo) as
                         *  parameters with the getString method. **/
                        DevelopersList developers = new DevelopersList(jo.getString("login"),
                                jo.getString("avatar_url"));
                        developersLists.add(developers);
                    }

                    /** Create the adapter and pass in the developersLists and the application context as its parameters, after which
                     *  we’ll set it as the RecyclerView adapter. **/
                    adapter = new DevelopersAdapter(developersLists, getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    // TODO: 5... create a new empty activity for profiles, call it "ProfileActivity".
}
