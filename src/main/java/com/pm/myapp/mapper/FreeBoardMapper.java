package com.pm.myapp.mapper;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.FreeBoardDTO;
import com.pm.myapp.domain.FreeBoardVO;
import com.pm.myapp.service.board.FreeBoardService;

import java.util.List;

public interface FreeBoardMapper {

    // 1. 게시판 목록 조회
    public abstract List<FreeBoardVO> getList();

    public abstract List<FreeBoardVO> getListWithPaging(Criteria criteria);

    // 2. 새로운 게시물 등록
    public abstract Integer insert (FreeBoardVO freeBoard);

    // 2. 자동 생성된 게시글 번호 얻기
    public abstract Integer insertSelectKey(FreeBoardDTO freeBoard);

    // 3. 특정 게시물 상세조회
    public abstract FreeBoardVO read(Integer frefer);

    //4. 특정 게시물 업데이트 수행
    public abstract int update(FreeBoardDTO freeBoard);

    //5. 특정 게시물 삭제
    public abstract int delete(Integer frefer);

    //6. 총 게시물 개수를 반환
    public abstract Integer getTotalCount();






}
