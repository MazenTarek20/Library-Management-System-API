package com.example.Library.Management.System.Model;

public class Magazine extends com.example.library.model.LibraryItem {

    private String publisher;
    private int issueNumber;

    public Magazine(String itemId, String title, String category,
                    String publisher, int issueNumber) {
        super(itemId, title, category);
        setPublisher(publisher);
        setIssueNumber(issueNumber);
    }

    private void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be empty.");
        }
        this.publisher = publisher;
    }

    private void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be greater than 0.");
        }
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        printCommon();
        System.out.println("Publisher: " + publisher);
        System.out.println("Issue Number: " + issueNumber);
    }

    public String getPublisher() {
        return publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}

