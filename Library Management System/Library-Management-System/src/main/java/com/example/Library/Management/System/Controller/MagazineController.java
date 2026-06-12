package com.example.Library.Management.System.Controller;


import com.example.Library.Management.System.Model.Magazine;
import com.example.Library.Management.System.Service.MagazineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magazines")
public class MagazineController {

    private final MagazineService magazineService;

    public MagazineController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    @PostMapping
    public String addMagazine(@RequestBody Magazine magazine) {
        magazineService.addMagazine(magazine);
        return "Magazine added successfully";
    }

    @GetMapping
    public List<Magazine> getAllMagazines() {
        return magazineService.getAllMagazines();
    }
}
