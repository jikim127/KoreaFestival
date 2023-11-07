package com.example.localevents.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ApiRequest {

    public static void main(String[] args) {
        try {
            // API 요청을 위한 URL 및 매개변수 설정
            String baseUrl = "http://apis.data.go.kr/B551011/KorService/areaCode";
            String serviceKey = "2DKGsJ2Z6SAvo6x54nNnQ2xP4OUCQcvuWxIghjoS3pC1dcCGNbVaQ5LefEPSOnifwNMKT1ehGEJrMBQ6s0qIEQ%3D%3D";
            int numOfRows = 10;
            int pageNo = 1;
            String mobileOS = "ETC";
            String mobileApp = "TestApp";
            String responseType = "json";

            // API 요청 URL 생성
            String apiUrl = baseUrl + "?serviceKey=" + serviceKey +
                    "&numOfRows=" + numOfRows +
                    "&pageNo=" + pageNo +
                    "&MobileOS=" + mobileOS +
                    "&MobileApp=" + mobileApp +
                    "&_type=" + responseType;

            URL url = new URL(apiUrl);

            // HttpURLConnection을 사용하여 GET 요청 보내기
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // API 응답 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 응답 데이터를 처리
                String apiResponse = response.toString();
                System.out.println(apiResponse);
            } else {
                System.out.println("API 요청이 실패했습니다. 응답 코드: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}