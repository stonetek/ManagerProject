package com.stonetek.managerproject.services;


import com.stonetek.managerproject.dto.DeveloperDTO;
import com.stonetek.managerproject.entities.Developer;
import com.stonetek.managerproject.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository repository;

    @Transactional
    public List<DeveloperDTO> findAll() {
        List<Developer> list = repository.findAllByOrderByDeveloperNameAsc();
        return list.stream().map(x -> new DeveloperDTO(x)).collect(Collectors.toList());
    }
}
