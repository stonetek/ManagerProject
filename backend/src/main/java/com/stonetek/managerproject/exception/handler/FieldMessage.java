package com.stonetek.managerproject.exception.handler;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FieldMessage {

	@Column(name = "fieldName")
	private String fieldName;

	@Column(name = "messageError")
	private String messageError;
}