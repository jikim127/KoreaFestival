package com.example.localevents.entity;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.processing.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

@Generated("con.querydsl.codegen.DefaultEntitySerializer")
public class QFestival extends EntityPathBase<FestivalItem> {

    private static final long serialVersionUID = -359095989L;

    public static final QFestival festival = new QFestival("festival");

    public final StringPath fstvl_start_date = createString("fstvl_start_date");

    public final StringPath fstvl_end_date = createString("fstvl_end_date");

    public final StringPath fstvl_nm = createString("fstvl_nm");

    public final StringPath m_Recommend = createString("m_Recommend");

    public final StringPath rdnmadr = createString("rdnmadr");

    public final StringPath fstvl_co = createString("fstvl_co");

    public final StringPath homepage_url = createString("homepage_url");

//    public final NumberPath<Integer> mPlayCount = createNumber("mPlayCount", Integer.class);

    public final NumberPath<Long> no = createNumber("no", Long.class);

//    public final ListPath<PlayList, QPlayList> playLists = this.<PlayList, QPlayList>createList("playLists", PlayList.class, QPlayList.class, PathInits.DIRECT2);

//    public final NumberPath<Integer> rDate = createNumber("rDate", Integer.class);

//    public final ListPath<Reply, QReply> replies = this.<Reply, QReply>createList("replies", Reply.class, QReply.class, PathInits.DIRECT2);

    public QFestival(String variable) {
        super(FestivalItem.class, forVariable(variable));
    }

    public QFestival(Path<? extends FestivalItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFestival(PathMetadata metadata) { super(FestivalItem.class, metadata); }

}
