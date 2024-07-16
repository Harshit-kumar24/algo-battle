package com.algobattle.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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
