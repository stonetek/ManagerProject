package com.stonetek.managerproject.util;

import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class ResourceUriUtil {
    @SuppressWarnings("null")
	public static void addUriInResponseHeader(Object idResource) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(idResource)
                .toUri();
        @SuppressWarnings("null")
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader(HttpHeaders.LOCATION, uri.toString());
    }

}
