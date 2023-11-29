package com.example.localevents.controller;

import com.example.localevents.dto.FestivalItemDTO;
import com.example.localevents.dto.PageRequestDTO;
import com.example.localevents.dto.PageResponseDTO;
import com.example.localevents.entity.FestivalItem;
import com.example.localevents.repository.FestivalItemRepository;
import com.example.localevents.repository.search.FestivalSearch;
import com.example.localevents.repository.search.FestivalSearchImpl;
import com.example.localevents.service.FestivalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CalendarController {

    private final FestivalService festivalService;
    private final FestivalSearch festivalSearch;

    @GetMapping({"/index", "/about-us", "/blog", "/blog-details", "/favSpot", "/leports"})
    public void main() {
    }

    @GetMapping("/events")
    public String showEvents(PageRequestDTO pageRequestDTO, Model model, Pageable pageable, FestivalItemDTO festivalItemDTO) {
        if (pageRequestDTO.isSearch()) {
            // 검색 조건이 있는 경우
            String[] types = pageRequestDTO.getTypes();
            String keyword = pageRequestDTO.getKeyword();

            Page<FestivalItem> festivalPage = festivalSearch.searchAll(types, keyword, pageable);

            model.addAttribute("festivalPage", festivalPage);
        } else {
            // 검색 조건이 없는 경우
            List<FestivalItem> festivalItemList = festivalService.getFestivalItemList();
            model.addAttribute("festivalItemList", festivalItemList);

            log.info("------festivalItemList : " + festivalItemList);
        }

        return "events";
    }

    @GetMapping( "/calendar")
    public String showCalendar(Model model, FestivalItemDTO festivalItemDTO) {
        List<FestivalItem> festivalItemList = festivalService.getFestivalItemList();
        model.addAttribute("festivalItemList", festivalItemList);

        log.info("------festivalItemList : " + festivalItemList);

        return "calendar";
    }

}
