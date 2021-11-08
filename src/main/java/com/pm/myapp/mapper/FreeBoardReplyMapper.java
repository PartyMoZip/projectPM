package com.pm.myapp.mapper;

import com.pm.myapp.domain.FreeBoardReplyVO;

import java.util.List;

public interface FreeBoardReplyMapper {

    // 1. 댓글 목록
    public abstract List<FreeBoardReplyVO> getList();

    // 2. 댓글 등록
    public abstract Integer insert(FreeBoardReplyVO freeBoardReply);

    // 3. 댓글 수정
    public abstract  int update(FreeBoardReplyVO freeBoardReply);

    // 4. 댓글 삭제
    public abstract int delete(Integer mfrrefer);

    // 5. 댓글 개수
    public abstract Integer getTotalReply();


}
