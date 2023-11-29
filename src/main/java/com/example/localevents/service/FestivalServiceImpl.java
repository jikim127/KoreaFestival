package com.example.localevents.service;

import com.example.localevents.dto.FestivalItemDTO;
import com.example.localevents.dto.PageRequestDTO;
import com.example.localevents.dto.PageResponseDTO;
import com.example.localevents.entity.FestivalItem;
import com.example.localevents.repository.FestivalItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor

public class FestivalServiceImpl implements FestivalService {

    @Autowired
    private FestivalItemRepository festivalItemRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FestivalItem saveFestivalItem(FestivalItem festivalItem) {
        return festivalItemRepository.save(festivalItem);
    }

    @Override
    public List<FestivalItem> saveAllFestivalItems(List<FestivalItem> festivalItems) {
        return festivalItemRepository.saveAll(festivalItems);
    }

    @Override
    public List<FestivalItem> getFestivalItemList() {
        Sort sortByColumn = Sort.by(Sort.Direction.DESC, "FstvlStartDate");
        return festivalItemRepository.findAll(sortByColumn);
    }

    @Override
    public PageResponseDTO<FestivalItemDTO> listWithPaging(PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<FestivalItem> result = festivalItemRepository.searchAll(types, keyword, pageable);

        List<FestivalItemDTO> dtoList = result.getContent().stream().map(festivalItem -> modelMapper.map(festivalItem, FestivalItemDTO.class)).collect(Collectors.toList());

        PageResponseDTO<FestivalItemDTO> pageResponseDTO = new PageResponseDTO<>(pageRequestDTO, dtoList, (int) result.getTotalElements());

        return pageResponseDTO;
    }
}
