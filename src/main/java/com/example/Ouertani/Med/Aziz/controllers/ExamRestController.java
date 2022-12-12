package com.example.Ouertani.Med.Aziz.controllers;


import com.example.Ouertani.Med.Aziz.entities.Parking;
import com.example.Ouertani.Med.Aziz.entities.Personnel;
import com.example.Ouertani.Med.Aziz.entities.Zone;
import com.example.Ouertani.Med.Aziz.repositories.ParkingRepo;
import com.example.Ouertani.Med.Aziz.repositories.PersonnelRepo;
import com.example.Ouertani.Med.Aziz.repositories.ZoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("exam")
public class ExamRestController {
    @Autowired
    ParkingRepo parkingRepo;
    @Autowired
    PersonnelRepo personnelRepo;
    @Autowired
    ZoneRepo zoneRepo;


    //http://localhost:9090/rest/add-personnel
    @PostMapping("/add-personnel")
    public Personnel addPersonnel (@RequestBody Personnel personnel) {
        return personnelRepo.save(personnel);
    }


    //http://localhost:9090/rest/add-parking
    @PostMapping("/add-parking")
    public Parking ajoutParkingetZone (@RequestBody Parking parking)
    {
        return parkingRepo.save(parking);
    }

    @PostMapping("/{idZone}/{idGarde}")
    public Zone affecterPersonnelZone(@PathVariable  int idZone, @PathVariable  int idGarde ) {
        Zone zone=zoneRepo.findById(idZone).orElse(null);
        Personnel garde=personnelRepo.findById(idGarde).orElse(null);

        if(zone!=null && garde!=null){
            Set<Personnel> personnelSet=zone.getPersonnels();

            if (garde.getPoste().toString()!="RESPONSABLE"){
                personnelSet.add(garde);
                zone.setPersonnels(personnelSet);
                return zoneRepo.save(zone);
            }
        }
 return null;

    }

    @GetMapping("/getPersonnelByDate/{startDate}/{endDate}")
    public List<Personnel> getPersonnelByDate(
                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

      return personnelRepo.getPersonnelByDateDeRecrutementBetween(startDate,endDate);

    }
//
//public Integer nombreGardeJour(String adresse){
//        Parking parking= parkingRepo.getParkingsByAdresse(adresse);
//        List<Zone> zoneList=zoneRepo.getZoneByParking(parking);
//int x=0;
//          zoneList.stream().map(Zone::getPersonnels).map(personnels -> {
//         personnels.stream().map(personnel -> {
//             if(personnel.getPoste().toString()=="GARDE_JOUR")
//                 {
//                     x=x+1;
//                 }
//             });
//
//});
//         return x;
//
//
//
//
//}

    @Scheduled(fixedRate = 300000)
    public void getNbrGardeByZone() {
        zoneRepo.findAll().stream()
                .forEach(z->{
                    log.info("Le nombre des gardes de la zone "+ z.getRef()+" est égale à "+ z.getPersonnels().size());
                });


    }

}
