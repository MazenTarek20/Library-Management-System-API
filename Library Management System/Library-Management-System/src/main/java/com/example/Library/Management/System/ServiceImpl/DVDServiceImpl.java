package com.example.Library.Management.System.ServiceImpl;

import com.example.Library.Management.System.Model.DVD;
import com.example.Library.Management.System.Service.DvdService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DVDServiceImpl implements DvdService {

    private final List<DVD> dvds = new ArrayList<>();

    @Override
    public void addDVD(DVD dvd) {
        dvds.add(dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        return dvds;
    }
}
