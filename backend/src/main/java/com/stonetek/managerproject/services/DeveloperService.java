package com.stonetek.managerproject.services;

import com.stonetek.managerproject.dto.mapper.DeveloperMapper;
import com.stonetek.managerproject.dto.request.DeveloperRequest;
import com.stonetek.managerproject.dto.response.DeveloperResponse;
import com.stonetek.managerproject.entities.Developer;
import com.stonetek.managerproject.exception.DeveloperNotFoundException;
import com.stonetek.managerproject.repositories.DeveloperRepository;
import com.stonetek.managerproject.util.ResourceUriUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public List<DeveloperResponse> listar() {
        List<Developer> developers = developerRepository.findAll();
        return DeveloperMapper.converter(developers);
    }

    public DeveloperResponse salvar(DeveloperRequest request) {
        Developer developer = DeveloperMapper.converter(request);
        developer = developerRepository.save(developer);
        ResourceUriUtil.addUriInResponseHeader(developer.getId()); // Adiciona no header da resquição o recurso que foi
                                                                   // criado
        return DeveloperMapper.converter(developer);
    }

    public DeveloperResponse buscarPorId(Integer idDeveloper) {
        Optional<Developer> developer = developerRepository.findById(idDeveloper);
        if (developer.isEmpty()) {
            throw new DeveloperNotFoundException(idDeveloper);
        }
        return DeveloperMapper.converter(developer.get());
    }

    public DeveloperResponse editar(Integer idDeveloper, DeveloperRequest request) {
        DeveloperResponse developerEncontrado = buscarPorId(idDeveloper);
        Developer developer = DeveloperMapper.converter(developerEncontrado);
        DeveloperMapper.copyToProperties(request, developer);
        developer = developerRepository.save(developer);
        return DeveloperMapper.converter(developer);
    }

    public void excluir(Integer idDeveloper) {
        try {
            developerRepository.deleteById(idDeveloper);
        } catch (EmptyResultDataAccessException ex) {
            throw new DeveloperNotFoundException(idDeveloper);
        }
    }

}