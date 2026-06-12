package com.example.Library.Management.System.Model;

public class DVD extends com.example.library.model.LibraryItem {

    private String director;
    private int durationMinutes;

    public DVD(String itemId, String title, String category,
               String director, int durationMinutes) {
        super(itemId, title, category);
        setDirector(director);
        setDurationMinutes(durationMinutes);
    }

    private void setDirector(String director) {
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("Director cannot be empty.");
        }
        this.director = director;
    }

    private void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void displayInfo() {
        printCommon();
        System.out.println("Director: " + director);
        System.out.println("Duration: " + durationMinutes + " minutes");
    }

    public String getDirector() {
        return director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }
}
