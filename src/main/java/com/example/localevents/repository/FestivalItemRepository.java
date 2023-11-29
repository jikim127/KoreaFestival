package com.example.localevents.repository;

import com.example.localevents.entity.FestivalItem;
import com.example.localevents.repository.search.FestivalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalItemRepository extends JpaRepository<FestivalItem, Long>, FestivalSearch {
//
//    Page<FestivalItem> searchOne(Pageable pageable);
//
//    Page<FestivalItem> searchAll(String[] types, String keyword, Pageable pageable);
}
