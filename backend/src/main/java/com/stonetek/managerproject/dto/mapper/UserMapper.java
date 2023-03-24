package com.stonetek.managerproject.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Destination;

import org.modelmapper.ModelMapper;

import com.stonetek.managerproject.dto.request.UserRequest;
import com.stonetek.managerproject.dto.response.UserResponse;
import com.stonetek.managerproject.entities.User;

public class UserMapper {

    private final static ModelMapper mapper = new ModelMapper();
    
    public static UserResponse converter(User user) {
        return mapper.map(user, UserResponse.class);
    }

    public static User converter(UserRequest request) {
        return mapper.map(request, User.class);
    }
	
	public static User converter(UserResponse response) {
        return mapper.map(response, User.class);
    }
	
	public static List<UserResponse> converter(List<User> users) {
        return users.stream().map(UserMapper::converter).collect(Collectors.toList());
    }
	
	public static void copyToProperties(UserRequest request, User user) {
        mapper.map(request, user);
    }
}
