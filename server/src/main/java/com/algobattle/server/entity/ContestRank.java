package com.algobattle.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
