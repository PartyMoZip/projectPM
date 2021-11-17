package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.board.NoticeBoardDTO;
import com.pm.myapp.domain.board.NoticeBoardListVO;
import com.pm.myapp.domain.board.NoticeBoardSearchVO;
import com.pm.myapp.domain.board.NoticeBoardVO;
import com.pm.myapp.mapper.board.NoticeBoardMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

    @Setter(onMethod_= {@Autowired})
    private NoticeBoardMapper mapper;

    // 공지 게시판 목록 - 페이징 처리
    @Override
    public List<NoticeBoardListVO> getListPerPage(Criteria cri) {
        log.debug("getListPerPage({}) invoked.",cri);
        List<NoticeBoardListVO> allBoards = this.mapper.getListWithPaging(cri);
        log.info("\t + allBoards : {}", allBoards);

        return allBoards;
    }

    // 공지 게시판 상세보기
    @Override
    public NoticeBoardVO getBoardDetail(Integer nrefer) {
        log.debug("get({}) invoked.", nrefer);
        NoticeBoardVO noticeBoard = this.mapper.readNoticeBoard(nrefer);
        log.info("\t + noticeBoard : {}", noticeBoard);

        return noticeBoard;
    }

    // 공지 게시판 글쓰기
    @Override
    public boolean writeBoard(NoticeBoardDTO writeNB) {
        log.debug("writeBoard({}) invoked.", writeNB);

        int affectedRows = this.mapper.writeNoticeBoard(writeNB);
        log.debug("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // writeBoard

    // 공지 게시판 글수정
    @Override
    public boolean editBoard(NoticeBoardDTO noticeBoard) {
        log.debug("editBoard({}) invoked.", noticeBoard);

        int affectedRows = this.mapper.editNoticeBoard(noticeBoard);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // modify

    // 글삭제
    @Override
    public boolean deleteBoard(Integer nrefer) {
        log.debug("remove({}) invoked.", nrefer);

        int affectedRows = this.mapper.deleteNoticeBoard(nrefer);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // remove

    // 게시물 검색
    @Override
    public List<NoticeBoardSearchVO> search(String searchOption, String keyword, Criteria cri) {
        String searchOption_mod = "n." + searchOption;
        String keyword_mod = "%" + keyword + "%";
        List<NoticeBoardSearchVO> searchList = this.mapper.searchNoticeBoard(searchOption_mod, keyword_mod, cri);

        return searchList;
    } // search

    // 총 게시물 개수 반환
    @Override
    public Integer getTotal() {
        log.debug("getTotal({}) invoked.");

        return this.mapper.getTotalCount();
    }
}
