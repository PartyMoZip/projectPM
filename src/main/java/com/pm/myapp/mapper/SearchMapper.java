package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 검색 매퍼
public interface SearchMapper {

    // 파티 전체 조회
    public abstract List<PartyVO> getPartyList(Criteria cri);

    // 검색된 파티만 조회
    public abstract List<PartyVO> getPartyListBySearch(
            @Param("cri") Criteria cri,
            @Param("searchWord1") String searchWord1,
            @Param("searchWord2") String searchWord2,
            @Param("searchWord3") String searchWord3
    );

    // 총 파티 목록 개수
    public abstract Integer getTotalCount();

    // 검색어 포함된 총 파티 목록 개수
    public abstract Integer getTotalCountBySearch(
            @Param("searchWord1") String searchWord1,
            @Param("searchWord2") String searchWord2,
            @Param("searchWord3") String searchWord3
    );

} // end interface
