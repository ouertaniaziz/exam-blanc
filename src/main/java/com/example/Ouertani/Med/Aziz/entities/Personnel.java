package com.example.Ouertani.Med.Aziz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Personnel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonnel;

    private String prenom;
    private String nom;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date dateDeRecrutement;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Poste poste;

    @JsonIgnore
    @OneToOne
    private Zone zone;
}
