package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Model User")
@Entity
public class Persona {

	@Id
    @NotNull
    @ApiModelProperty(value = "the user's id", required = true)
	private int idPersona;


    @NotNull
    @ApiModelProperty(value = "the user's dni", required = true)
	private String dni;

    @NotNull
    @ApiModelProperty(value = "the user's name", required = true)
	private String nombre;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
