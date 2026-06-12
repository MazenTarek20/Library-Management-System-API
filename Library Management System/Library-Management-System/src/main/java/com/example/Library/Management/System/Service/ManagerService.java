package com.example.Library.Management.System.Service;



import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Model.DVD;
import com.example.Library.Management.System.Model.Magazine;

import java.lang.reflect.Member;
import java.util.ArrayList;

public interface ManagerService {

    void addBook(Book book);

    void addMagazine(Magazine magazine);

    void addDVD(DVD dvd);

    void displayAllItems();

    void displayAvailableItems();

    com.example.library.model.LibraryItem findItemById(String itemId);

    void addMember(Member member);

    void displayAllMembers();

    Member findMemberByName(String memberName);

    boolean borrowItem(String itemId, String memberName);

    boolean returnItem(String itemId, boolean isLate);

    void displayBorrowedItems();

    void displayStatistics();

    ArrayList<com.example.library.model.LibraryItem> searchByTitle(String title);

    int getTotalItems();
}
