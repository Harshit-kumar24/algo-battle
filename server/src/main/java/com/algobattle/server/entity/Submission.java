package com.algoBattle.server.entity;

import java.time.LocalDateTime;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "submission", schema = "public")
public class Submission {

	public enum Status {
		QU, AC, WA, CE, RE, TL, ML, SE, RF, CJ, PE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "submission_id")
	private UUID submissionId;

	@ManyToOne
	@JoinColumn(name = "problem_id")
	private Problem problem;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "created_time")
	private LocalDateTime createdTime;

	@Column(name = "status")
	private Status status;

	@Column(name = "memory")
	private Long memory;

	@Column(name = "time")
	private Double time;

	@OneToOne(mappedBy = "submission", cascade = CascadeType.ALL)
	private TestSubmission testSubmission;

}
