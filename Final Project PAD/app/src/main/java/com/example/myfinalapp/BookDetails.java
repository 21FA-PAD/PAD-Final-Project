package com.example.myfinalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookDetails extends AppCompatActivity {
    String title, subtitle, publisher, publishedDate, description, thumbnail, previewLink, infoLink, buyLink;
    int pageCount;
    private ArrayList<String> authors;

    TextView tvTitle, tvSubs, tvPublisher, tvDesc, tvPage, tvPublishedDate;
    Button btnPreview, btnBuy;
    private ImageView bookIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        tvTitle = findViewById(R.id.tvTitle);
        tvPublisher = findViewById(R.id.tvPublisher);
        tvDesc = findViewById(R.id.tvDesc);
        tvPage = findViewById(R.id.tvNumPages);
        btnPreview = findViewById(R.id.btnPreview);
        btnBuy = findViewById(R.id.btnBuy);
        bookIV = (ImageView) findViewById(R.id.ivBook);

        title = getIntent().getStringExtra("title");
        publisher = getIntent().getStringExtra("publisher");
        description = getIntent().getStringExtra("description");
        pageCount = getIntent().getIntExtra("pageCount", 0);
        thumbnail = getIntent().getStringExtra("thumbnail");
        previewLink = getIntent().getStringExtra("previewLink");
        infoLink = getIntent().getStringExtra("infoLink");
        buyLink = getIntent().getStringExtra("buyLink");

        tvTitle.setText(title);
        tvPublisher.setText(publisher);
        tvDesc.setText(description);
        tvPage.setText("No Of Pages : " + pageCount);
        Picasso.get().load(thumbnail).into(bookIV); // does not work

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previewLink.isEmpty()) {
                    Toast.makeText(BookDetails.this, "No preview Link present", Toast.LENGTH_SHORT).show();
                    return;
                }
                Uri uri = Uri.parse(previewLink);
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buyLink.isEmpty()) {
                    Toast.makeText(BookDetails.this, "No buy page present for this book", Toast.LENGTH_SHORT).show();
                    return;
                }
                Uri uri = Uri.parse(buyLink);
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
    }
}
