package com.stonetek.managerproject.dto.mapper;

import com.stonetek.managerproject.dto.request.DeveloperRequest;
import com.stonetek.managerproject.dto.response.DeveloperResponse;
import com.stonetek.managerproject.entities.Developer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class DeveloperMapper {
	
	private final static ModelMapper mapper = new ModelMapper();
    
	public static DeveloperResponse converter(Developer developer) {
        return mapper.map(developer, DeveloperResponse.class);
    }
	
	public static Developer converter(DeveloperRequest request) {
        return mapper.map(request, Developer.class);
    }
	
	public static Developer converter(DeveloperResponse response) {
        return mapper.map(response, Developer.class);
    }
	
	public static List<DeveloperResponse> converter(List<Developer> developers) {
        return developers.stream().map(DeveloperMapper::converter).collect(Collectors.toList());
    }
	
	public static void copyToProperties(DeveloperRequest request, Developer developer) {
        mapper.map(request, developer);
    }

}

