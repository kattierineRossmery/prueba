package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Model User")
@Entity
@Data
public class Persona {

	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the user's id", required = true)
	private int idPersona;


    @NotNull
    @ApiModelProperty(value = "the user's dni", required = true)
	private String dni;

    @NotNull
    @ApiModelProperty(value = "the user's name", required = true)
	private String nombre;

}
