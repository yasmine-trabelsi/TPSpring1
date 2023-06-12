package com.example.demo.repository;

import com.example.demo.entity.Skieur;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface ISkieurRepo extends JpaRepository<Skieur, Long> {
    public Skieur findByNomSAndPrenomS(String nomS, String prenomS);

    public Skieur findByDateNaissanceGreaterThan(Date dateNaissance);

    public Skieur findByNomSAndPrenomSAndDateNaissance(String nomS, String prenomS, Date dateNaissance);

    @Query(value = "Select a from Skieur a where a.dateNaissance< :dateNai", nativeQuery = true)
    Skieur rechercherParDate(@Param("dateNai ") Date dateNai);

    @Query(value="select S from Skieur S where S.nomS = :nom and S.prenomS = :prenom")
    public Skieur getSkieurByNomAndPrenom(@Param("nom") String nom ,@Param("prenom") String prenom);
}
