package com.university.service;
import com.university.model.Alumni;
import com.university.repository.AlumniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumniService {
    @Autowired
    private AlumniRepository alumniRepository;

    public List<Alumni> getAllAlumni() {
        return alumniRepository.findAll();
    }

    public Alumni saveAlumni(Alumni alumni) {
        return alumniRepository.save(alumni);
    }
}