package com.algoBattle.server.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "problem", schema = "public")
public class Problem {

	public enum Diff {
		EASY, MEDIUM, HARD
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "problem_id")
	private UUID problemId;

	@Column(name = "title")
	private String title;

	@Column(name = "slug")
	private String slug;

	@Column(name = "description")
	private String description;

	@Column(name = "points")
	private Long points;

	@ManyToOne
	@JoinColumn(name = "contest_id")
	private Contest contest;

	@Column(name = "hidden")
	private Boolean hidden;

	@Column(name = "difficulty")
	private Diff difficulty;

	@Column(name = "accepted")
	private Long accepted;

	@CreationTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "createdDate")
	private LocalDate createdDate;

	@OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
	private List<Submission> submissions = new ArrayList<>();

}
