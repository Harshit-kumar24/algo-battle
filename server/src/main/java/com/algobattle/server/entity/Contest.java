package com.algoBattle.server.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contest", schema = "public")
public class Contest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contest_id",nullable = false)
	private Long contestId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "division")
	private Long division;

	@Column(name = "start_time")
	private LocalDateTime startTime;

	@Column(name = "end_time")
	private LocalDateTime endTime;

	@Column(name = "hidden")
	private Boolean hidden;

	@CreationTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	@Column(name = "created_at")
	private LocalDateTime createdAt;
 
	@OneToMany(mappedBy = "contest", cascade = CascadeType.ALL)
	private List<Problem> problems;
	
	@OneToMany(mappedBy = "rankContest",cascade = CascadeType.ALL)
	private List<ContestRank> contestRank;

}
