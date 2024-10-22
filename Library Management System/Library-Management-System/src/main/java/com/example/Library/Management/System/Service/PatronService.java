package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Model.Patron;
import com.example.Library.Management.System.Repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatronService {
    public List<Patron> getAllPatrons();

    public Patron getPatronById(int id);

    public Patron createPatron(Patron patron);

    public Patron updatePatron(int id, Patron updatedPatron);

    public void deletePatron(int id);
}
