package com.example.myfinalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private ArrayList<Book> bookInfo;
    private ProgressBar progressBar;
    private EditText editSearch;
    private ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.idLoadingPB);
        editSearch = findViewById(R.id.idEdtSearchBooks);
        btnSearch = findViewById(R.id.idBtnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                if (editSearch.getText().toString().isEmpty()) {
                    editSearch.setError("Please enter search query");
                    return;
                }
                getBooksInfo(editSearch.getText().toString());
            }
        });
    }

    private void getBooksInfo(String query) {

        bookInfo = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.getCache().clear();
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + query;
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest booksObjrequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONArray itemsArray = response.getJSONArray("items");
                    for (int i = 0; i < itemsArray.length(); i++) {
                        JSONObject itemsObj = itemsArray.getJSONObject(i);
                        JSONObject volumeObj = itemsObj.getJSONObject("volumeInfo");
                        JSONObject imageLinks = volumeObj.optJSONObject("imageLinks");
                        JSONObject saleInfoObj = itemsObj.optJSONObject("saleInfo");
                        JSONArray authorsArray = volumeObj.getJSONArray("authors");


                        String title = volumeObj.optString("title");
                        String subtitle = volumeObj.optString("subtitle");
                        String publisher = volumeObj.optString("publisher");
                        String publishedDate = volumeObj.optString("publishedDate");
                        String description = volumeObj.optString("description");
                        String thumbnail = imageLinks.optString("thumbnail");
                        String previewLink = volumeObj.optString("previewLink");
                        String infoLink = volumeObj.optString("infoLink");
                        String buyLink = saleInfoObj.optString("buyLink");
                        int pageCount = volumeObj.optInt("pageCount");

                        ArrayList<String> authorsArrayList = new ArrayList<>();
                        if (authorsArray.length() != 0) {
                            for (int j = 0; j < authorsArray.length(); j++) {
                                authorsArrayList.add(authorsArray.optString(i));
                            }
                        }
                        Book book = new Book(title, authorsArrayList, publisher, description, pageCount, thumbnail, previewLink, infoLink, buyLink);
                        bookInfo.add(book);

                        BookAdapter adapter = new BookAdapter(bookInfo, MainActivity.this);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

                        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rvBooks);
                        mRecyclerView.setLayoutManager(linearLayoutManager);
                        mRecyclerView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "No Data Found" + e, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error found is " + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(booksObjrequest);
    }
}
