package com.example.my_application_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import androidx.test.espresso.IdlingRegistry;
//import androidx.test.espresso.idling.CountingIdlingResource;

public class TopLevelActivity extends AppCompatActivity {
    private ArrayList<CafeProduct> products = new ArrayList<CafeProduct>();
    private CoffeeAdapter productsAdpt;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        productsAdpt = new CoffeeAdapter(products);
        RecyclerView listView = (RecyclerView) findViewById(R.id.productList);

        layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);

        listView.setAdapter(productsAdpt);
    }
    public void onRequestProducts(View view) {
        //ApiCountingIdlingResources.increment();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, "https://www.sjjg.uk/coffee-shop/getAllProducts", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        populateList(response);
                        //ApiCountingIdlingResources.decrement();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // ApiCountingIdlingResources.decrement();
                    }
                }
        );
        requestQueue.add(getRequest);
    }

    private void populateList(JSONArray items) {
        products.clear();
        try {
            for (int i = 0; i < items.length(); i++) {
                JSONObject jo = items.getJSONObject(i);
                products.add(new CafeProduct(jo.getString("name"), jo.getInt("id")));
            }
        } catch (JSONException err) {
        }
        productsAdpt.notifyDataSetChanged();

    }
    public  void populate( View view) {

    }
}