package com.example.localevents.service;

import com.example.localevents.entity.FestivalItem;

import java.util.List;

public interface FestivalService {

    FestivalItem saveFestivalItem(FestivalItem festivalItem);

    List<FestivalItem> saveAllFestivalItems(List<FestivalItem> festivalItems);

    List<FestivalItem> getFestivalItemList();
}
