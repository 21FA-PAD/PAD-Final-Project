package com.example.myfinalapp;

import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private int pageCount;
    private String thumbnail;
    private String previewLink;
    private String infoLink;
    private String buyLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink;
    }


    public Book (String title, ArrayList<String> authors, String publisher,
                 String description, int pageCount, String thumbnail,
                 String previewLink, String infoLink, String buyLink) {


        setTitle(title);
        setAuthors(authors);
        setPublisher(publisher);
        setDescription(description);
        setPageCount(pageCount);
        setThumbnail(thumbnail);
        setPreviewLink(previewLink);
        setInfoLink(infoLink);
        setBuyLink(buyLink);
    }
}
