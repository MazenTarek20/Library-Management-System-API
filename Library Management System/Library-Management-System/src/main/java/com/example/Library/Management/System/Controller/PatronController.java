package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Model.Patron;
import com.example.Library.Management.System.Service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping("/getAllPatrons")
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable int patronId) {
        return patronService.getPatronById(patronId);
    }

    @PostMapping("/createPatron")
    public Patron createPatron(@RequestBody Patron patron) {
        return patronService.createPatron(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable int id, @RequestBody Patron updatedPatron) {
        return patronService.updatePatron(id, updatedPatron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable int id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
