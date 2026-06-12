package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Model.DVD;

import java.util.List;

public interface DvdService {
    void addDVD(DVD dvd);

    List<DVD> getAllDVDs();
}
