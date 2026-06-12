package com.example.Library.Management.System.ServiceImpl;

import com.example.Library.Management.System.Model.Magazine;
import com.example.Library.Management.System.Service.MagazineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagazineServiceImpl implements MagazineService {

    private final List<Magazine> magazines = new ArrayList<>();

    @Override
    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    @Override
    public List<Magazine> getAllMagazines() {
        return magazines;
    }
}
