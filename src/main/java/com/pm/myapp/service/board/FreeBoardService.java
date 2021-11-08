package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.FreeBoardDTO;
import com.pm.myapp.domain.FreeBoardVO;

import java.util.List;

public interface FreeBoardService {

    // 1. 게시글 등록
    public abstract boolean register(FreeBoardDTO freeBard);

    // 2. 기존 게시글 수정
    public abstract boolean modify(FreeBoardDTO freeBoard);

    // 3. 기존 게시글의 삭제
    public abstract boolean remove(Integer frefer);

    // 4. 특정 게시물의 상세조회
    public abstract FreeBoardVO get(Integer frefer);

    // 5. 전체 게시물의 목록조회
    public abstract List<FreeBoardVO> getList();

    // 6. 페이징 처리
    public abstract  List<FreeBoardVO> getListPerPage(Criteria criteria);

    // 7. 총 게시물 개수 반환
    public abstract Integer getTotal();

} //end interface
