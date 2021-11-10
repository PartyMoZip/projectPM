package com.pm.myapp.service.main;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.PartyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchService {

    // 페이징 파티 목록 조회
    public abstract List<PartyVO> getPartyList(Criteria cri);

    // 페이징 검색어 포함된 파티 목록 조회
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

} //end interface
