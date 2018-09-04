package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Los String deben ser validado con @NotEmpty
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;
	
	//Spring-boot utiliza el formato de fecha segun nuestra configuracion ejm: MM/DD/YYYY
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date createdAt;
	
	private String foto;
	
	public Cliente() {}
	
	/**
	 * Este metodo se invoca automaticamente antes de producirse la persistencia del cliente en la BD
	 
	@PrePersist
	public void prePersist()
	{
		createdAt = new Date();
	}
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date created) {
		this.createdAt = created;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString()
	{
		return "[Cliente id: " + id + "nombre: " + nombre + " ]"; 
	}
}
