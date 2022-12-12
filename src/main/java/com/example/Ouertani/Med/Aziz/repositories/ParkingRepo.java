package com.example.Ouertani.Med.Aziz.repositories;

import com.example.Ouertani.Med.Aziz.entities.Parking;
import com.example.Ouertani.Med.Aziz.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingRepo extends JpaRepository<Parking,Integer> {
    Parking getParkingsByAdresse(String Adresse);
}
