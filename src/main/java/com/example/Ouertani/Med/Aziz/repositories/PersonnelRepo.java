package com.example.Ouertani.Med.Aziz.repositories;

import com.example.Ouertani.Med.Aziz.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface PersonnelRepo extends JpaRepository<Personnel,Integer> {

    List<Personnel> getPersonnelByDateDeRecrutementBetween(Date Datedebut, Date Datefin);
}
