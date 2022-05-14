package com.idat.idat_Nicolas_EVAL3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;


@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer idCliente;
	  private String nombre;
	  private String celular;
	  
	  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	  @JoinTable(name="cliente_hospital",
	  joinColumns = @JoinColumn(name="id_Cliente",nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign Key(id_Cliente) references clientes(id_Cliente)")),
	  inverseJoinColumns = @JoinColumn(name="id_Hospital", nullable=false, unique=true,foreignKey = 
	  @ForeignKey(foreignKeyDefinition=
	  "foreign Key(id_Hospital) references hospitales(id_Hospital)")))
	  
	  private List<Hospital> hospitales = new ArrayList<>();
	  
	  @OneToOne(mappedBy="clientes")
	  private UsuarioCliente usuarios;
	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
}
