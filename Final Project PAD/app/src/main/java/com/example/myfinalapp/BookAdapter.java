package com.example.myfinalapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<Book> bookInfo;
    private Context bcontext;

    public BookAdapter(ArrayList<Book> bookInfo, Context bcontext) {
        this.bookInfo = bookInfo;
        this.bcontext = bcontext;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_list, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        Book bi = bookInfo.get(position);
        holder.tvName.setText(bi.getTitle());
        holder.tvPublisher.setText(bi.getPublisher());
        holder.tvPageC.setText("No of Pages : " + bi.getPageCount());
        Picasso.get().load(bi.getThumbnail()).into(holder.ivBook);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(bcontext, BookDetails.class);
                i.putExtra("title", bi.getTitle());
                i.putExtra("authors", bi.getAuthors());
                i.putExtra("publisher", bi.getPublisher());
                i.putExtra("description", bi.getDescription());
                i.putExtra("pageCount", bi.getPageCount());
                i.putExtra("thumbnail", bi.getThumbnail());
                i.putExtra("previewLink", bi.getPreviewLink());
                i.putExtra("infoLink", bi.getInfoLink());
                i.putExtra("buyLink", bi.getBuyLink());

                bcontext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookInfo.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPublisher, tvPageC, tvDate;
        ImageView ivBook;

        public BookViewHolder(View iv) {
            super(iv);
            tvName = iv.findViewById(R.id.tvBookTitleil);
            tvPublisher = iv.findViewById(R.id.tvPublisheril);
            tvPageC = iv.findViewById(R.id.tvPageCountil);
            tvDate = iv.findViewById(R.id.tvDateil);
            ivBook = iv.findViewById(R.id.bivBook);
        }
    }
}
