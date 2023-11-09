package com.example.localevents.controller;

import com.example.localevents.dto.FestivalItemDTO;
import com.example.localevents.entity.FestivalItem;
import com.example.localevents.service.FestivalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CalendarController {

    private final FestivalService festivalService;

    @GetMapping({"/index", "/about-us", "/blog", "/blog-details", "/favSpot", "/leports"})
    public void main() {
    }


    @GetMapping({"/events", "/calendar"})
    public String showEvents(Model model, FestivalItemDTO festivalItemDTO) {
        List<FestivalItem> festivalItemList = festivalService.getFestivalItemList();
        model.addAttribute("festivalItemList", festivalItemList);

        log.info("------festivalItemList : " + festivalItemList);

        if (RequestMappingHandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE.equals("/events")) {
            return "events";
        } else {
            return "calendar";
        }
    }

}
