package com.example.demo.service;

import com.example.demo.entity.Cours;
import com.example.demo.entity.Support;
import com.example.demo.repository.ICoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursServiceImpl implements ICoursService {
    @Autowired
    ICoursRepo iCoursRepo ;
    @Override
    public Cours findCoursBySupport(Support S) {
        return iCoursRepo.findAllBySupport(S);
    }
}
