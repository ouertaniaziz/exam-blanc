package com.example.Ouertani.Med.Aziz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Parking implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParking;

    private String designation;
    private String adresse;
    private int capacite;
@JsonIgnore
    @OneToMany(mappedBy = "parking")
    private Set<Zone> zoneSet;



}
