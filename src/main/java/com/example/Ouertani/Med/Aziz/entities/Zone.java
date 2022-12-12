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
public class Zone implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZone;

    private String ref;
    private float dimension;



    @ManyToOne
      Parking parking;

    @JsonIgnore
    @OneToMany
    private Set<Personnel> personnels;

    @JsonIgnore
    @OneToOne(mappedBy = "zone")
    private Personnel personnelResp;


}
