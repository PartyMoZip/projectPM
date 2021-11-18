package com.pm.myapp.service.board;

import com.pm.myapp.domain.*;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.mapper.board.FreeBoardMapper;
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
public class FreeBoardServiceImpl implements FreeBoardService, InitializingBean, DisposableBean {

    @Setter(onMethod_= {@Autowired})
    private FreeBoardMapper mapper;

    // 자유 게시판 목록 - 페이징 처리
    @Override
    public List<FreeBoardListVO> getListPerPage(Criteria cri) {
        log.debug("getListPerPage({}) invoked.", cri);
        List<FreeBoardListVO> allBoards = this.mapper.getListWithPaging(cri);
        log.info("\t + allBoards : {}", allBoards);

        return allBoards;
    } // getListPerPage

    // 자유 게시판 상세보기
    @Override
    public FreeBoardVO getBoardDetail(Integer frefer) {
        log.debug("getBoardDetail({}) invoked.", frefer);

        FreeBoardVO boardDetail = this.mapper.readFreeBoard(frefer);
        log.info("\t + boardDetail : {}", boardDetail);

        return boardDetail;
    } // getBoardDetail

    // 자유 게시판 글쓰기
    @Override
    public boolean writeBoard(FreeBoardDTO writeFB) {
        log.debug("writeBoard({}) invoked.", writeFB);

        int affectedRows = this.mapper.registerFreeBoard(writeFB);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // writeBoard

    // 자유 게시판 글수정
    @Override
    public boolean editBoard(FreeBoardDTO freeBoard) {
        log.debug("editBoard({}) invoked.", freeBoard);

        int affectedRows = this.mapper.updateFreeBoard(freeBoard);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // modify
    
    // 자유 게시판 글삭제
    @Override
    public boolean deleteBoard(Integer frefer) {
        log.debug("remove({}) invoked.", frefer);

        int affectedRows = this.mapper.deleteFreeBoard(frefer);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // remove

    // 자유 게시글 검색
    @Override
    public List<FreeBoardSearchVO> search(String searchOption, String keyword, Criteria cri) {
        String searchOption_mod = "f." + searchOption;
        String keyword_mod = "%"+keyword+"%";

        List<FreeBoardSearchVO> searchList = this.mapper.searchFreeBoard(searchOption_mod, keyword_mod, cri);

        return searchList;
    } // search

    // 총 게시물 개수 반환
    @Override
    public Integer getTotal() {
        log.debug("getTotal() invoked.");

        return this.mapper.getTotalCount();
    } // getTotal

    // 댓글 목록
    @Override
    public List<FreeBoardReplyVO> getReply(Integer frefer, Criteria cri) {
        log.debug("getListReply() invoked.");


        List<FreeBoardReplyVO> allReply = this.mapper.getCommentListPaging(frefer, cri);
        log.info("\t + allReply : {}", allReply);

        return allReply;
    } // getListReply

    // 댓글 등록
    public boolean writeReply(FreeBoardReplyDTO freeReply) {
        log.debug("writeReply({}) invoked.", freeReply);

        int affectedRows = this.mapper.writeComment(freeReply);
        log.info("\t + affectedRows", affectedRows);

        return (affectedRows == 1);
    } // writeComment

    // 댓글 수정
    public boolean editReply(FreeBoardReplyDTO freeReply) {
        log.debug("editReply({}) invoked.", freeReply);

        int affectedRows = this.mapper.editComment(freeReply);
        log.info("\t + affectedRows", affectedRows);

        return (affectedRows == 1);
    } // editComment


    // 댓글 삭제
    public boolean deleteReply(Integer frerefer) {
        log.debug("deleteReply({}) invoked.", frerefer);

        int affectedRows = this.mapper.deleteComment(frerefer);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows==1);
    } // deleteReply

    // 댓글 개수
    @Override
    public Integer getTotalReply() {
        log.debug("getTotalReply({}) invoked.");

        return this.mapper.getTotalReply();


    }


    @Override
    public void destroy() throws Exception {
        log.debug("destroy() invoked.");

    } // destroy

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet() invoked.");

        assert this.mapper!=null;
        log.info("\t + mapper : " + this.mapper);

    } // afterPropertiesSet

}
