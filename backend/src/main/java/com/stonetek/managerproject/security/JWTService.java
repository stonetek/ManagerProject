package com.stonetek.managerproject.security;

import java.util.Date;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.stonetek.managerproject.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@RequiredArgsConstructor
@Service
public class JWTService {
	private static final String mainKeyJWT = "secretKey";
	
	/**
	 * Método para gerar token JWT.
	 * @param authentication Autenticação do usuario
	 * @return Token.
	 */
	public String gerarToken(Authentication authentication) {
		//Um dia em milisegundos.
		//Pode varioar de acordo com a regra de negócio.
		int tempoExpiracao = 86400000;
		
		//Criando data de expiração do token com base no tempo de expiração.
		Date dataExpiracao = new Date(new Date().getTime() + tempoExpiracao);
		
		//Pegando o usuario atual da autenticação.
		User user = (User) authentication.getPrincipal();
		
		//Metodo que pega todos os dados e retorna um token JWT.
		return Jwts.builder()
				.setSubject(user.getId().toString())
				.setIssuedAt(new Date())
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS512, mainKeyJWT)
				.compact();
	}
	
	
	/**
	 * Método para retornar o id do user dono do token.
	 * @param token do user
	 * @return id do user.
	 */
	public Optional<Long> obterIdDoUsuario(String token) {
		
		try {
			Claims claims = parse(token).getBody();
			
			return Optional.ofNullable(Long.parseLong(claims.getSubject())); 
			
		} catch (Exception e) {
			return Optional.empty();
			
		}
	}

	private Jws<Claims> parse(String token) {
		return Jwts.parser().setSigningKey(mainKeyJWT).parseClaimsJws(token);
	}
}
