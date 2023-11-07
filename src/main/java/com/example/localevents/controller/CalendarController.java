package com.example.localevents.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Log4j2
public class CalendarController {

    @GetMapping({"/index","/about-us", "/blog", "/blog-details", "/calendar", "/favSpot", "/leports"})
    public void main() {
    }


    @GetMapping("/events")
    public String showEvents(Model model, RestTestController festivalItems) {
        // FestivalItems 데이터를 모델에 추가
        model.addAttribute("festivalItems3", festivalItems);

        log.info("------festivalItems3 : " + festivalItems);

        return "events"; // events.html을 템플릿으로 사용
    }

}
