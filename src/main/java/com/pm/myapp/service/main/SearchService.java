package com.pm.myapp.service.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.domain.SearchWordDTO;

import java.util.List;

public interface SearchService {

    // 페이징 파티 목록 조회
    public abstract List<PartyVO> getPartyList(Criteria cri);

    // 페이징 검색어 포함된 파티 목록 조회
    public abstract List<PartyVO> getPartyListBySearch(
            Criteria cri,
            SearchWordDTO searchWord
    );

    // 페이징 카테고리 선택된 조건으로 조회
    public abstract List<PartyVO> getPartyListBySelected(
            Criteria cri,
            SearchWordDTO searchWord
    );

    // 총 파티 목록 개수
    public abstract Integer getTotalCount();

    // 검색어 포함된 총 파티 목록 개수
    public abstract Integer getTotalCountBySearch(
            SearchWordDTO searchWord
    );

    // 카테고리 선택된 조건 총 파티 목록 개수
    public abstract Integer getTotalCountBySelected(
            SearchWordDTO searchWord
    );

} //end interface
