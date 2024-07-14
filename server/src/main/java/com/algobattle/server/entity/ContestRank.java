package com.algoBattle.server.entity;

import java.util.UUID;

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
@Table(name = "contest_rank", schema = "public ")
public class ContestRank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "contest_rank_id")
	private UUID contestRankId;
	
	@ManyToOne
	@JoinColumn(name = "contest_id") 
	private Contest rankContest;
	 
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "points")
	private Long points;
}
