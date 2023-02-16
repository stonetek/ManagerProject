package com.stonetek.managerproject.exception.handler;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class StandardError {

	@Column(name = "timestamp")
	private Long timestamp;

	@Column(name = "statuscode")
	private Integer statusCode;

	@Column(name = "error")
	private String error;

}