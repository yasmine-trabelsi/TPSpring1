package com.example.demo.repository;

import com.example.demo.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface IInscriptionRepo extends JpaRepository<Inscription,Long> {
}
