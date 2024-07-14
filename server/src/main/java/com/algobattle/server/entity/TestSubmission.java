package com.algoBattle.server.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_submission",schema = "public")
public class TestSubmission {
 	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "source_code")
	private String sourceCode;

	@Column(name = "language_id")
	private Long languageId;

	@Column(name = "stdin")
	private String stdin;

	@Column(name = "expected_output")
	private String exptectedOutput;

	@Column(name = "stdout")
	private String stdout;
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name = "create_time")
	private LocalDateTime createdTime;

	@Column(name = "time")
	private Double time;

	@Column(name = "memory")
	private Long memory;

	@Column(name = "stderr")
	private String stderr ;

	@Column(name = "compiled_output")
	private String compiledOutput;

	@Column(name = "callback_url")
	private String callbackUrl;

	@OneToOne
	@JoinColumn(name = "submission_id")
	private Submission submission;
}
