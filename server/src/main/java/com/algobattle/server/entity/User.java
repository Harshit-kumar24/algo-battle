package com.algobattle.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "total_submissions")
    private Long totalSubmissions;

    @Column(name = "total_accepted")
    private Long totalAccepted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Submission> submission;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ContestRank contestRank;
}
