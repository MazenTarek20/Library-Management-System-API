package com.example.Library.Management.System.Repository;

import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Integer> {

}
