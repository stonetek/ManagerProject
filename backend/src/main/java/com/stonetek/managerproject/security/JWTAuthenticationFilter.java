package com.stonetek.managerproject.security;

import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	private JWTService jwtService;

	@Autowired
	private  CustomUserDetailsService customUserDetailsService;
	
	//Metodo principal onde toda a requisição bate antes de chegar no nosso endpoint.
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			//Pego o token de dentro da requisição.
			String token = obterToken(request);
			
			//Pego o id do usuario que está dentro do token.
			Optional<Long> id = jwtService.obterIdDoUsuario(token);
			
			//Se não achou o id é por quê o usuario não mandou o token correto.
			if(id.isPresent()) {			
			//pego o usuario dono do token pelo seu id.
			UserDetails user = customUserDetailsService.buscarUserPorId(id.get());
			
			
			//Verificação se o usuario está autenticado ou não. Também poderia ser feita a validação das permissões.
			UsernamePasswordAuthenticationToken autenticacao =
					new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			
			//Mudando a autenticação para a própria requisição.
			autenticacao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			//Repasso a autenticação para o contexto do security
			//Agora o spring toma conta de toda a segurança para mim.
			SecurityContextHolder.getContext().setAuthentication(autenticacao);
			}
			//Método padrão para filtar as regras do usuario caso esteja cadastrando novo usuário.
			filterChain.doFilter(request, response);
	}
	
	private String obterToken(HttpServletRequest request) {
			
			String token = request.getHeader("Authorization");
			
			//Verifica se veio alguma coisa sem ser espaços em branco dentro do token.
			if(!StringUtils.hasText(token)) {
				return null; 
			}
			
			return token.substring(7);
	}

}