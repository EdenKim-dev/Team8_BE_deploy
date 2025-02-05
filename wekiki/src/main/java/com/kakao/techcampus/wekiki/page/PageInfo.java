package com.kakao.techcampus.wekiki.page;

import com.kakao.techcampus.wekiki.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pageinfo_tb")
public class PageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Group group;
    private String pageName;
    private int goodCount;
    private int badCount;
    private int viewCount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Builder
    public PageInfo(Long id, Group group, String pageName, int goodCount, int badCount, int viewCount, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.group = group;
        this.pageName = pageName;
        this.goodCount = goodCount;
        this.badCount = badCount;
        this.viewCount = viewCount;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void plusGoodCount(){
        this.goodCount++;
    }

    public void plusBadCount(){
        this.badCount++;
    }

    public void updatePage(){
        this.updated_at = LocalDateTime.now();
    }


}
