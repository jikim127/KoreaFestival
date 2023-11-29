package com.example.localevents.repository.search;

import com.example.localevents.entity.FestivalItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FestivalSearch {

    Page<FestivalItem> searchOne(Pageable pageable);

    Page<FestivalItem> searchAll(String[] types, String keyword, Pageable pageable);
}
