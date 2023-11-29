package com.example.localevents.repository.search;

import com.example.localevents.entity.FestivalItem;
import com.example.localevents.entity.QFestival;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class FestivalSearchImpl extends QuerydslRepositorySupport implements FestivalSearch{

    public FestivalSearchImpl() { super(FestivalItem.class); }

    @Override
    public Page<FestivalItem> searchOne(Pageable pageable) {
        QFestival Festival = QFestival.festival;
        JPQLQuery<FestivalItem> query = from(Festival);
        query.where(Festival.fstvl_nm.contains("1"));

        this.getQuerydsl().applyPagination(pageable, query);

        List<FestivalItem> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<FestivalItem> searchAll(String[] types, String keyword, Pageable pageable) {
        QFestival festival = QFestival.festival;
        JPQLQuery<FestivalItem> query = from(festival);

        if ((types != null && types.length > 0) && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for (String type : types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(festival.fstvl_start_date.contains(keyword));
                        break;
                    case "l" :
                        booleanBuilder.or(festival.rdnmadr.contains(keyword));
                        break;
                    case "k" :
                        booleanBuilder.or(festival.fstvl_nm.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }
        System.out.println("query ============================>"+ query);

        query.where(festival.no.gt(0L));
        System.out.println("query ============================>"+ query);

        this.getQuerydsl().applyPagination(pageable,query);

        List<FestivalItem> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list,pageable,count);
    }
}

