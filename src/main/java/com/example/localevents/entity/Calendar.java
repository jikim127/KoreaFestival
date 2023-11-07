package com.example.localevents.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long calNo;

    private String calName;

    private String startDate;

    private String endDate;

    private String startTime;

    private String endTime;

    private String description;

    private String colorTag;

    // fk키
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserCal", // 매핑 테이블 이름
            joinColumns = @JoinColumn(name = "calNo"), // Calendar와 연결된 컬럼
            inverseJoinColumns = @JoinColumn(name = "idNo") // User와 연결된 컬럼
    )
    private List<User> users; // User 엔티티와의 관계

}
