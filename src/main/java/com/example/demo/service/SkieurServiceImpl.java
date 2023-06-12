package com.example.demo.service;

import com.example.demo.entity.Piste;
import com.example.demo.entity.Skieur;
import com.example.demo.repository.IPisteRepo;
import com.example.demo.repository.ISkieurRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SkieurServiceImpl implements ISkieurService{

    //@Autowired
    private ISkieurRepo iSkieurRepo ;
    private IPisteRepo iPisteRepo ;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return iSkieurRepo.save(skieur);
    }

    @Override
    public List<Skieur> getAllSkieur() {
        return  iSkieurRepo.findAll();
    }

    @Override
    public Skieur getSkieurById(Long id) {
        return iSkieurRepo.findById(id).get();//orElseNull
    }

    @Override
    public void deletteSkieur(Long id) {
        iSkieurRepo.deleteById(id);
    }

    @Override
    public Skieur updateSkieur(Long id) {
        Skieur S = iSkieurRepo.findById(id).get();
        //  return addSkieur(S);
        return iSkieurRepo.save(S);
    }

    @Override
    public Skieur getSkieurByLastNameAndFirstName(String nom, String prenom) {
        return iSkieurRepo.getSkieurByNomAndPrenom(nom, prenom);
    }

    @Override
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
       Skieur S= this.getSkieurById(numSkieur);
       Piste P= iPisteRepo.findById(numPiste).get();
       P.getSkieurs().add(S);
       S.getPistes().add(P);
       this.addSkieur(S);
      // iPisteRepo.save(P);
       return S;
    }

}
