package com.example.Library.Management.System.ServiceImpl;

import com.example.Library.Management.System.Model.Patron;
import com.example.Library.Management.System.Repository.PatronRepository;
import com.example.Library.Management.System.Service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public Patron getPatronById(int id) {
        return patronRepository.findById(id).orElseThrow(() -> new RuntimeException("Patron not found"));
    }

    @Override
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public Patron updatePatron(int id, Patron updatedPatron) {
        Patron patron = getPatronById(id);
        patron.setName(updatedPatron.getName());
        patron.setContactInfo(updatedPatron.getContactInfo());
        return patronRepository.save(patron);
    }

    @Override
    public void deletePatron(int id) {
        patronRepository.deleteById(id);
    }
}
