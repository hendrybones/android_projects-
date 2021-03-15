package com.example.reclerjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ExampleAdapter.onItemClickListener{
public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_CREATOR="CreatorName";
    public static final String EXTRA_LIKES="likeCount";

    private RecyclerView mRecylerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem>mExampleList;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecylerView=findViewById(R.id.recyler_view);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));


        mExampleList=new ArrayList<>();
        mRequestQueue= Volley.newRequestQueue(this);
        parseJSON();
    }
    private void parseJSON(){
        String url="https://pixabay.com/api/?key=15579442-70c3f874b85e6d6ed57ea9398&q=yellow+flowers&image_type=photo&pretty=true";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("hits");
                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject hit=jsonArray.getJSONObject(i);

                                String CreatorName=hit.getString("user");
                                String imageUrl=hit.getString("webFormatURL");
                                int likeCount=hit.getInt("likes");

                                mExampleList.add(new ExampleItem(imageUrl,CreatorName,likeCount));

                            }
                            mExampleAdapter=new ExampleAdapter(MainActivity.this,mExampleList);
                            mRecylerView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent=new Intent(this,DetailActivity.class);
        ExampleItem clickedItem=mExampleList.get(position);

        detailIntent.putExtra(EXTRA_URL,clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR,clickedItem.getCreator());
        detailIntent.putExtra(EXTRA_LIKES,clickedItem.getLikesCount());

        startActivity(detailIntent);
    }
}
