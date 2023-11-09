package com.example.localevents.service;

import com.example.localevents.dto.FestivalItemDTO;
import com.example.localevents.entity.FestivalItem;
import com.example.localevents.repository.FestivalItemRepository;
import jakarta.persistence.AssociationOverride;
import jakarta.persistence.OrderBy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class FestivalServiceImpl implements FestivalService {

    @Autowired
    private FestivalItemRepository festivalItemRepository;

    public FestivalItem saveFestivalItem(FestivalItem festivalItem) {
        return festivalItemRepository.save(festivalItem);
    }

    public List<FestivalItem> saveAllFestivalItems(List<FestivalItem> festivalItems) {
        return festivalItemRepository.saveAll(festivalItems);
    }

    public List<FestivalItem> getFestivalItemList() {
        Sort sortByColumn = Sort.by(Sort.Direction.DESC, "FstvlStartDate");
        return festivalItemRepository.findAll(sortByColumn);
    }
}
