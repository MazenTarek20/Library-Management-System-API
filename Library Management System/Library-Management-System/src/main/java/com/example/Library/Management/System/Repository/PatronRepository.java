package com.example.Library.Management.System.Repository;

import com.example.Library.Management.System.Model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron,Integer> {
}
