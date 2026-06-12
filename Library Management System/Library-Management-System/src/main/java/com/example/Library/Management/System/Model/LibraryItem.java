package com.example.library.model;

public abstract class LibraryItem {

    private String itemId;
    private String title;
    private String category;
    private boolean isAvailable;
    private String borrowedBy;

    public LibraryItem(String itemId, String title, String category) {
        setItemId(itemId);
        setTitle(title);
        setCategory(category);
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    private void setItemId(String itemId) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be empty.");
        }
        this.itemId = itemId;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    private void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }
        this.category = category;
    }

    public void borrow(String memberName) {
        if (memberName == null || memberName.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty.");
        }

        this.isAvailable = false;
        this.borrowedBy = memberName;
    }

    public void returnItem() {
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    protected void printCommon() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public abstract void displayInfo();

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }
}
