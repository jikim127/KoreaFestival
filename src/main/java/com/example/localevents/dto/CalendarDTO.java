package com.example.localevents.dto;

import com.example.localevents.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CalendarDTO {

    private Long calNo;

    private String calName;

    private String startDate;

    private String endDate;

    private String startTime;

    private String endTime;

    private String description;

    private String colorTag;

    private List<User> users;
}
