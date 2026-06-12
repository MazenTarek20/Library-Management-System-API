package com.example.Library.Management.System.ServiceImpl;

import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Model.DVD;
import com.example.Library.Management.System.Model.Magazine;
import com.example.Library.Management.System.Service.ManagerService;
import com.example.library.model.LibraryItem;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;

@Service
public class ManagerServiceImpl implements ManagerService {

    private String libraryName;

    private final ArrayList<com.example.library.model.LibraryItem> items;
    private final ArrayList<Member> members;

    public ManagerServiceImpl() {
        this.libraryName = "Library Management System";
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        items.add(book);
        System.out.println("Book added successfully.");
    }

    @Override
    public void addMagazine(Magazine magazine) {
        items.add(magazine);
        System.out.println("Magazine added successfully.");
    }

    @Override
    public void addDVD(DVD dvd) {
        items.add(dvd);
        System.out.println("DVD added successfully.");
    }

    @Override
    public void displayAllItems() {

        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (com.example.library.model.LibraryItem item : items) {
            item.displayInfo();
            System.out.println("-------------------");
        }
    }

    @Override
    public void displayAvailableItems() {

        for (com.example.library.model.LibraryItem item : items) {
            if (item.isAvailable()) {
                item.displayInfo();
                System.out.println("-------------------");
            }
        }
    }

    @Override
    public com.example.library.model.LibraryItem findItemById(String itemId) {

        for (com.example.library.model.LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                return item;
            }
        }

        return null;
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added successfully.");
    }

    @Override
    public void displayAllMembers() {

        for (Member member : members) {
            member.toString();
            System.out.println("-------------------");
        }
    }

    @Override
    public Member findMemberByName(String memberName) {

        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public boolean borrowItem(String itemId, String memberName) {

        com.example.library.model.LibraryItem item = findItemById(itemId);
        Member member = findMemberByName(memberName);

        if (item == null || member == null) {
            return false;
        }

        if (!item.isAvailable()) {
            return false;
        }

        if (!member.clone()) {
            return false;
        }

        item.borrow(memberName);
        member.wait();

        return true;
    }

    @Override
    public boolean returnItem(String itemId, boolean isLate) {

        com.example.library.model.LibraryItem item = findItemById(itemId);

        if (item == null || item.getBorrowedBy() == null) {
            return false;
        }

        Member member = findMemberByName(item.getBorrowedBy());

        if (member == null) {
            return false;
        }

        if (isLate) {
            member.addFine(15.0);
        }

        item.returnItem();
        member.returnItem();

        return true;
    }

    @Override
    public void displayBorrowedItems() {

        for (com.example.library.model.LibraryItem item : items) {

            if (!item.isAvailable()) {
                item.displayInfo();
                System.out.println("Borrowed By: " + item.getBorrowedBy());
                System.out.println("-------------------");
            }
        }
    }

    @Override
    public void displayStatistics() {

        int available = 0;
        int borrowed = 0;

        for (com.example.library.model.LibraryItem item : items) {

            if (item.isAvailable()) {
                available++;
            } else {
                borrowed++;
            }
        }

        System.out.println("Library Name: " + libraryName);
        System.out.println("Total Items: " + items.size());
        System.out.println("Available Items: " + available);
        System.out.println("Borrowed Items: " + borrowed);
        System.out.println("Total Members: " + members.size());
    }

    @Override
    public ArrayList<LibraryItem> searchByTitle(String title) {

        ArrayList<LibraryItem> results = new ArrayList<>();

        for (LibraryItem item : items) {

            if (item.getTitle()
                    .toLowerCase()
                    .contains(title.toLowerCase())) {

                results.add(item);
            }
        }

        return results;
    }

    @Override
    public int getTotalItems() {
        return items.size();
    }
}
