package com.example.localevents.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Ignore;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * JSON 데이터 파싱하기
 */
@Entity
@Getter
@Setter
@ToString
public class FestivalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fstvlNm;
    private String opar;
    private String fstvlStartDate;
    private String fstvlEndDate;
    private String fstvlCo;
    private String rdnmadr;
    private String homepageUrl;
    private String relateInfo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String suprtInsttNm;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String auspcInsttNm;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String latitude;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String lnmadr;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String mnnstNm;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int insttCode;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String phoneNumber;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String referenceDate;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String longitude;

}
