package com.example.localevents.controller;

import com.example.localevents.entity.FestivalItem;
import com.example.localevents.service.FestivalService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
@ResponseBody
@Getter
@Setter
@RequiredArgsConstructor
@RequestMapping(value = "/jsonapi", method = RequestMethod.GET)
public class FestivalController {

    private final FestivalService festivalService;

    /**
     * REST API 호출하기
     */
    @GetMapping
    public List<FestivalItem> callApiWithJson(Model model, FestivalItem festivalItem, HttpServletRequest request) throws IllegalStateException {
        List<FestivalItem> festivalItems = new ArrayList<>();

        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;

        String baseUrl = "http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api";
        String serviceKey = "EHW%2BrhIh278vOom%2FpjJ5ea7fUNc7nBjhuHwjzAiIHyg04uFczluezxnH%2BMdt6kl1NtoCDggBgfS2HLmGYFQ8WA%3D%3D";
        int pageNo = 1;
        int numOfRows = 100;
        String type = "xml";

        // API 요청 URL 생성
        try {
            String apiUrl = baseUrl + "?serviceKey=" + serviceKey +
                    "&pageNo=" + pageNo +
                    "&numOfRows=" + numOfRows +
                    "&type=" + type;

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }

            JSONObject jsonObject = XML.toJSONObject(result.toString());


            JSONObject items = jsonObject.getJSONObject("response").getJSONObject("body").getJSONObject("items");
            JSONArray itemArray = items.getJSONArray("item");

            // Jackson ObjectMapper를 사용하여 JSON을 Java 객체로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            festivalItems = objectMapper.readValue(itemArray.toString(), new TypeReference<List<FestivalItem>>() {
            });

            log.info("----festivalItems1 : " + festivalItems);

            // FestivalItemEntity로 변환하여 데이터베이스에 저장
            List<FestivalItem> festivalItemEntities = festivalItems.stream()
                    .map(festivalItemEntity -> {
                        FestivalItem entity = new FestivalItem();
                        entity.setFstvlNm(festivalItemEntity.getFstvlNm());
                        entity.setOpar(festivalItemEntity.getOpar());
                        entity.setFstvlStartDate(festivalItemEntity.getFstvlStartDate());
                        entity.setFstvlEndDate(festivalItemEntity.getFstvlEndDate());
                        entity.setFstvlCo(festivalItemEntity.getFstvlCo());
                        entity.setRdnmadr(festivalItemEntity.getRdnmadr());
                        entity.setHomepageUrl(festivalItemEntity.getHomepageUrl());
                        entity.setRelateInfo(festivalItemEntity.getRelateInfo());
                        return entity;
                    })
                    .collect(Collectors.toList());

            // 데이터베이스에 저장
            festivalService.saveAllFestivalItems(festivalItemEntities);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return festivalItems;
    }
}

