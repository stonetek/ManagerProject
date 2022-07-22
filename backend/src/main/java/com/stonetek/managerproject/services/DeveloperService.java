package com.stonetek.managerproject.services;


import com.stonetek.managerproject.dto.mapper.DeveloperMapper;
import com.stonetek.managerproject.dto.response.DeveloperResponse;
import com.stonetek.managerproject.entities.Developer;
import com.stonetek.managerproject.exception.DeveloperNotFoundException;
import com.stonetek.managerproject.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository repository;

//    public List<DeveloperDTO> findAllII() {
//        List<Developer> list = repository.findAllByOrderByDeveloperNameAsc();
//        return list.stream().map(x -> new DeveloperDTO(x)).collect(Collectors.toList());
//    }
//
//    @Transactional
//    public DeveloperDTO insert(DeveloperDTO dto) {
//        Developer developer = new Developer(null, dto.getDeveloperName(), dto.getEmail(), dto.getBirthDate(), dto.getSalary()
//        , dto.getWorkload());
//        developer = repository.save(developer);
//        return new DeveloperDTO(developer);
//    }
//
//
//    public DeveloperDTO updateById(Long id) {
//        Optional<Developer> op = repository.findById(id);
//        if (op.isPresent()) {
//            Developer obj = op.get();
//            repository.save(obj);
//            return new DeveloperDTO(obj);
//        }
//        return null;
//    }

    public List<DeveloperResponse> findAll(Pageable pageable) {
        List<Developer> developerList = repository.findAllByOrderByDeveloperNameAsc();
        return DeveloperMapper.toList(developerList);
    }

    public Developer save(Developer developer) {
        return repository.save(developer);
    }

    public Developer findById(Long idDeveloper) {
        return repository
                .findById(idDeveloper)
                .orElseThrow(() -> new DeveloperNotFoundException(idDeveloper));
    }

    public void delete(Long idDeveloper) {
        try {
            repository.deleteById(idDeveloper);
        } catch (EmptyResultDataAccessException e) {
            throw new DeveloperNotFoundException(idDeveloper);
        }
    }

}