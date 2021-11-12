package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// 검색 매퍼
public interface SearchMapper {

    // 파티 전체 조회
    public abstract List<PartyVO> getPartyList(Criteria cri);

    // 검색된 파티만 조회
    public abstract List<PartyVO> getPartyListBySearch(
            @Param("cri") Criteria cri,
            @Param("searchWord") SearchWordDTO searchWord
    );

    // 카테고리 선택된 조건으로 조회
    public abstract List<PartyVO> getPartyListBySelected(
            @Param("cri") Criteria cri,
            @Param("searchWord") SearchWordDTO searchWord
    );

    // 총 파티 목록 개수
    public abstract Integer getTotalCount();

    // 검색어 포함된 총 파티 목록 개수
    public abstract Integer getTotalCountBySearch(
            SearchWordDTO searchWord
    );

} // end interface
