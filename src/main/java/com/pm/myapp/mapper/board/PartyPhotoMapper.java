package com.pm.myapp.mapper.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;

import java.util.List;

public interface PartyPhotoMapper {

    // 1. 게시판 목록 조회
    public abstract List<PartyPhotoVO> getList();

    public abstract List<PartyPhotoVO> getListWithPaging(Criteria criteria);

    // 2. 새로운 게시물 등록
    public abstract Integer insert (PartyPhotoVO partyPhoto);

    // 2. 자동 생성된 게시글 번호 얻기
    public abstract Integer insertSelectKey(PartyPhotoDTO partyPhoto);

    // 3. 게시물 상세조회
    public abstract FreeBoardListVO read(Integer prefer);

    //4. 게시물 수정
    public abstract int update(PartyPhotoDTO partyPhoto);

    //5. 게시물 삭제
    public abstract int remove(Integer prefer);

    //6. 총 게시물 개수를 반환
    public abstract Integer getTotalCount();

    // 7. 댓글 목록
    public abstract List<FreeBoardReplyVO> getListReply();

    // 8. 댓글 등록
    public abstract Integer insert(FreeBoardReplyVO freeReply);

    // 9. 댓글 수정
    public abstract  int update(FreeBoardReplyDTO freeReply);

    // 10. 댓글 삭제
    public abstract int delete(Integer mfrrefer);

    // 11. 댓글 개수
    public abstract Integer getTotalReply();

    // 12. 댓글 번호 생성
    public abstract Integer insertRefer(FreeBoardReplyDTO freeReply);



}
