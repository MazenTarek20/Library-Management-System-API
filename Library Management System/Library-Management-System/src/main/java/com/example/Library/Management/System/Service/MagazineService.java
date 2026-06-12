package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Model.Magazine;

import java.util.List;

public interface MagazineService {
    void addMagazine(Magazine magazine);

    List<Magazine> getAllMagazines();
}
