package com.example.jurir.minuapp;

public class BookItem {
    private String title;
    private String image;
    private String author;
    private String description;
    private boolean isSelected;

    public BookItem(String title, String image, String author, String description) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.description = description;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() { return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
