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
@Table(name = "setter",schema = "public")
public class Setter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "setter_id")
	private UUID setterId;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "rating")
	private Long rating;

	@Column(name = "total_submissions")
	private Long totalSubmissions;

	@Column(name = "total_accepted")
	private Long totalAccepted;
}
