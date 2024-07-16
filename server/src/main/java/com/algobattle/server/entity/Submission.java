package com.algobattle.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

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
