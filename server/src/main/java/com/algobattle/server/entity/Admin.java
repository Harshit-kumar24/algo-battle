package com.algoBattle.server.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin", schema = "public")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "admin_id")
	private UUID adminId;

	@Column(name = "username")
	private String username;

	@Column(name = "name")
	private String name; 

	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;

}
