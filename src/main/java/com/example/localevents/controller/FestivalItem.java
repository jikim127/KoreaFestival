package com.example.localevents.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JSON 데이터 파싱하기
 */
@Getter
@Setter
@ToString

public class FestivalItem {
    private String suprtInsttNm;
    private String auspcInsttNm;
    private String opar;
    private String latitude;
    private String lnmadr;
    private String fstvlStartDate;
    private String mnnstNm;
    private String fstvlNm;
    private int insttCode;
    private String rdnmadr;
    private String phoneNumber;
    private String homepageUrl;
    private String relateInfo;
    private String fstvlEndDate;
    private String fstvlCo;
    private String referenceDate;
    private String longitude;

    // Getter and Setter methods
}
