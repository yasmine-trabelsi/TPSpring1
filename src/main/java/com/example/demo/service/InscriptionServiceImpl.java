package com.example.demo.service;

import com.example.demo.entity.Cours;
import com.example.demo.entity.Inscription;
import com.example.demo.repository.ICoursRepo;
import com.example.demo.repository.IInscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionServiceImpl implements  IInscriptionService {
    @Autowired
    IInscriptionRepo iInscriptionRepo ;
    @Autowired
    ICoursRepo iCoursRepo ;
    @Override
    public Inscription assignInscriptionToCours(Long numInscri, Long numCours) {
       Inscription Inscri = iInscriptionRepo.findById(numInscri).get();
       Cours cours= iCoursRepo.findById(numCours).get();
       Inscri.setCours(cours);
       cours.getInscri().add(Inscri);
       iCoursRepo.save(cours);
       return Inscri;
    }
}
