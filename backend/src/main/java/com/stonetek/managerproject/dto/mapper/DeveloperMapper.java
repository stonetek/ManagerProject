package com.stonetek.managerproject.dto.mapper;

import com.stonetek.managerproject.dto.request.DeveloperRequest;
import com.stonetek.managerproject.dto.response.DeveloperResponse;
import com.stonetek.managerproject.entities.Developer;

import java.util.List;
import java.util.stream.Collectors;

public class DeveloperMapper {

    public static Developer to(DeveloperRequest request) {
        Developer developer = new Developer();
        developer.setDeveloperName(request.getDeveloperName());
        developer.setEmail(request.getEmail());
        developer.setBirthDate(request.getBirthDate());
        developer.setSalary(request.getSalary());
        developer.setWorkload(request.getWorkload());
        return developer;
    }

    public static DeveloperResponse to(Developer developer) {
        DeveloperResponse response = new DeveloperResponse();
        response.setId(developer.getId());
        response.setDeveloperName(developer.getDeveloperName());
        response.setEmail(developer.getEmail());
        response.setBirthDate(developer.getBirthDate());
        response.setSalary(developer.getSalary());
        response.setWorkload(developer.getWorkload());
        return response;
    }

    public static void copyToProperties(DeveloperRequest request, Developer developer) {
        developer.setDeveloperName(request.getDeveloperName());
        developer.setEmail(request.getEmail());
        developer.setBirthDate(request.getBirthDate());
        developer.setSalary(request.getSalary());
        developer.setWorkload(request.getWorkload());
    }

    public static List<DeveloperResponse> toList(List<Developer> developerList) {
        return developerList.stream()
                .map(developer -> to(developer))
                .collect(Collectors.toList());
    }

}

