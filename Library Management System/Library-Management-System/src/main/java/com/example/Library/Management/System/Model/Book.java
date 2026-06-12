package com.example.Library.Management.System.Model;

public class Book extends com.example.library.model.LibraryItem {

    private String author;
    private int pageCount;

    public Book(String itemId, String title, String category,
                String author, int pageCount) {
        super(itemId, title, category);
        setAuthor(author);
        setPageCount(pageCount);
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        this.author = author;
    }

    private void setPageCount(int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be greater than 0.");
        }
        this.pageCount = pageCount;
    }

    @Override
    public void displayInfo() {
        printCommon();
        System.out.println("Author: " + author);
        System.out.println("Page Count: " + pageCount);
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }
}