package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.mapper.board.PartyFreeMapper;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
public class PartyFreeServiceImpl implements PartyFreeService, InitializingBean, DisposableBean {

    @Setter(onMethod_= @Autowired)
    private PartyFreeMapper mapper;

    // 파티 자유 게시판 목록 -  페이징 처리
    @Override
    public List<PartyFreeListVO> getListPerPage(Criteria cri) {
        log.debug("getListPerPage({}) invoked.", cri);
        List<PartyFreeListVO> partyFree = this.mapper.getListWithPaging(cri);
        log.info("\t + partyFree : {}", partyFree);
        return partyFree;
    }

    // 파티 자유 게시판 글쓰기
    @Override
    public boolean writeFBoard(PartyFreeDTO partyFree) {
        log.debug("register({}) invoked.", partyFree);
        int affectedRows = this.mapper.writePFreeBoard(partyFree);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    }

    // 파티 자유 게시판 상세보기
    @Override
    public PartyFreeVO getBoardDetail(Integer pfrefer, Integer partycode) {
        log.debug("get({}) invoked.", pfrefer);
        PartyFreeVO PFBoardDetail = this.mapper.readPFreeBoard(pfrefer, partycode);
        log.info("\t + freeBoard : {}", PFBoardDetail);

        return PFBoardDetail;
    } // getBoardDetail

    // 파티 자유 게시판 글수정
    @Override
    public boolean editBoard(PartyFreeDTO partyFree) {
        log.debug("modify({}) invoked.", partyFree);

        int affectedRows = this.mapper.editPFreeBoard(partyFree);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    }

    // 파티 자유 게시판 글삭제
    @Override
    public boolean deleteBoard(Integer pfrefer) {
        log.debug("remove({}) invoked.", pfrefer);

        int affectedRows = this.mapper.deletePFreeBoard(pfrefer);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    }

    // 파티 자유 게시판 검색
    @Override
    public List<PartyFreeSearchVO> search(String searchOption, String keyword, Criteria cri) {
        String searchOption_mod = "pf." + searchOption;
        String keyword_mod = "%" + keyword + "%";

        List<PartyFreeSearchVO> searchList = this.mapper.searchPartyFree(searchOption_mod, keyword_mod, cri);
        return searchList;
    }

    // 총 게시물 개수 반환
    @Override
    public Integer getTotal() {
        log.debug("getTotal() invoked.");
        return this.mapper.getTotalCount();
    }

    // 댓글 목록
    @Override
    public List<PartyFreeReplyVO> getReply(Integer pfrefer, Integer partycode, Criteria cri) {
        log.debug("getComment() invoked.");

        List<PartyFreeReplyVO> commentList= this.mapper.getCommentListPaging(pfrefer, partycode, cri);
        log.info("\t + allReply : {}", commentList);

        return commentList;
    }

    // 댓글 등록
    @Override
    public boolean writeReply(PartyFreeReplyDTO pfreeReply) {
        log.debug("editReply({}) invoked.", pfreeReply);

        int affectedRows = this.mapper.writeComment(pfreeReply);
        log.info("\t + affectedRows", affectedRows);

        return (affectedRows == 1);
    }

    // 댓글 수정
    @Override
    public boolean editReply(PartyFreeReplyDTO partyReply) {
        log.debug("editReply({}) invoked.", partyReply);

        int affectedRows = this.mapper.editComment(partyReply);
        log.info("\t + affectedRows", affectedRows);
        return (affectedRows == 1);
    }

    // 댓글 삭제
    @Override
    public boolean deleteReply(Integer pfrefer) {
        log.debug("deleteReply({}) invoked.", pfrefer);

        int affectedRows = this.mapper.deleteComment(pfrefer);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows==1);
    } // deleteComment


    // 댓글 개수
    @Override
    public Integer getTotalReply() {
        log.debug("getTotalReply({}) invoked.");

        return this.mapper.getTotalReply();
    }


    @Override
    public void destroy() throws Exception {
        log.debug("destroy() invoked.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet() invoked.");

        assert this.mapper!=null;
        log.info("\t + mapper : " + this.mapper);
    }
}
