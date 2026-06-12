package com.example.Library.Management.System.Controller;
import com.example.Library.Management.System.Model.DVD;
import com.example.Library.Management.System.Service.DvdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dvds")
public class DVDController {

    private final DvdService dvdService;

    public DVDController(DvdService dvdService) {
        this.dvdService = dvdService;
    }

    @PostMapping
    public String addDVD(@RequestBody DVD dvd) {
        dvdService.addDVD(dvd);
        return "DVD added successfully";
    }

    @GetMapping
    public List<DVD> getAllDVDs() {
        return dvdService.getAllDVDs();
    }
}
