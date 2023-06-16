package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Abonnement {
    @Id
    private int idFormation ;
    private String titre  ;
    private LocalDate dateFin ;
    private Float prixAbon ;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon ;

}
