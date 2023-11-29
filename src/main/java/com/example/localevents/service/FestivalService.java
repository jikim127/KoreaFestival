package com.example.localevents.service;

import com.example.localevents.dto.FestivalItemDTO;
import com.example.localevents.dto.PageRequestDTO;
import com.example.localevents.dto.PageResponseDTO;
import com.example.localevents.entity.FestivalItem;

import java.util.List;

public interface FestivalService {

    FestivalItem saveFestivalItem(FestivalItem festivalItem);

    List<FestivalItem> saveAllFestivalItems(List<FestivalItem> festivalItems);

    List<FestivalItem> getFestivalItemList();

    PageResponseDTO<FestivalItemDTO> listWithPaging(PageRequestDTO pageRequestDTO);
}
