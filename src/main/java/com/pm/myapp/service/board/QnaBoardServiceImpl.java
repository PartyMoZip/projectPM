package com.pm.myapp.service.board;
import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.*;
import com.pm.myapp.mapper.board.QnaBoardMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
public class QnaBoardServiceImpl implements QnaBoardService {

    @Setter(onMethod_=@Autowired)
    private QnaBoardMapper mapper;

    // 문의 게시판 목록 - 페이징 처리
    @Override
    public List<QnaBoardListVO> getListPerPage(String searchWord, Integer option, Criteria cri) {
        log.debug("getListPerPage({}) invoked.", cri);
        List<QnaBoardListVO> qnaBoard = this.mapper.getListWithPaging(searchWord, option, cri);
        log.info("\t + allBoards : {}", qnaBoard);

        return qnaBoard;
    }
    
    // 글쓰기
    @Override
    public boolean writeBoard(QnaBoardDTO qnaBoard) {
        log.debug("register({}) invoked.", qnaBoard);
        int affectedRows = this.mapper.writeQnaBoard(qnaBoard);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    }

    // 글수정
    @Override
    public boolean editBoard(QnaBoardDTO qnaBoard) {
        log.debug("modify({}) invoked.", qnaBoard);

        int affectedRows = this.mapper.editQnaBoard(qnaBoard);
        log.info("\t + affectedRows : {}", affectedRows);
        return (affectedRows == 1);
    }

    // 글삭제
    @Override
    public boolean deleteBoard(Integer qrefer) {
        log.debug("remove({}) invoked.", qrefer);

        int affectedRows = this.mapper.deleteQnaBoard(qrefer);
        log.info("\t + affectedRows : {}", affectedRows);
        return (affectedRows == 1);
    }

    // 게시물 상세보기
    @Override
    public QnaBoardVO getBoardDetail(Integer qrefer) {
        log.debug("get({}) invoked.", qrefer);
        QnaBoardVO qnaBoard = this.mapper.readQnaBoard(qrefer);
        log.info("\t + qnaBoard : {}", qnaBoard);

        return qnaBoard;
    }

    // 문의 게시판 검색
    @Override
    public List<QnaBoardSearchVO> search(String searchWord, Integer option, Criteria cri) {

        String searchOption_mod = "f." + searchWord;
        String keyword_mod = "%"+option+"%";
        List<QnaBoardSearchVO> searchList = this.mapper.searchQnaBoard(searchOption_mod, keyword_mod, cri);

        return searchList;
    }

    // 총 게시물 개수 반환
    @Override
    public Integer getTotal(String searchWord, Integer option) {
        log.debug("getTotal({}) invoked.");
        return this.mapper.getTotalCount(searchWord, option);
    }

    // 검색 결과 게시물 개수 반환
    @Override
    public Integer getTotalSearch(String searchWord, Integer option) {
        log.debug("getTotalSearch() invoked.");

        return this.mapper.getTotalSearchCount(searchWord, option);
    }

    // 댓글등록
    @Override
    public boolean writeReply(QnaBoardReplyDTO qnaReply) {
        log.debug("writeReply({}) invoked.", qnaReply);

        int affectedRows = this.mapper.writeComment(qnaReply);
        log.info("\t + affectedRows", affectedRows);

        return (affectedRows == 1);
    } // writeReply

    // 댓글 수정
    @Override
    public boolean editReply(QnaBoardReplyDTO QnaReply) {
        log.debug("editReply({}) invoked.", QnaReply);

        int affectedRows = this.mapper.editComment(QnaReply);
        log.info("\t + affectedRows", affectedRows);

        return (affectedRows == 1);
    }

    // 댓글 목록
    @Override
    public List<QnaBoardReplyVO> getReply(Integer qrefer, Criteria cri) {
        log.debug("getReply() invoked.");

        List<QnaBoardReplyVO> qnaReply = this.mapper.getCommentListPaging(qrefer, cri);
        log.info("\t + qnaReply : {}", qnaReply);

        return qnaReply;
    }

    // 댓글삭제
    @Override
    public boolean deleteReply(Integer qrerefer) {
        log.debug("deleteReply({}) invoked.", qrerefer);

        int affectedRows = this.mapper.deleteComment(qrerefer);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    }

    @Override
    public Integer getTotalReply() {
        log.debug("getTotalReply() invoked.");

        return this.mapper.getTotalComment();
    }


}
