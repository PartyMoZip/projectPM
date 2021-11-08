package com.pm.myapp.service.board;

import com.pm.myapp.domain.Criteria;
import com.pm.myapp.domain.FreeBoardDTO;
import com.pm.myapp.domain.FreeBoardVO;
import com.pm.myapp.mapper.FreeBoardMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

    private FreeBoardMapper mapper;

    @Override
    public boolean register(FreeBoardDTO freeBoard) {
        log.debug("register({}) invoked.", freeBoard);

        int affectedRows = this.mapper.insertSelectKey(freeBoard);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    } // register

    @Override
    public boolean modify(FreeBoardDTO freeBoard) {
        log.debug("modify({}) invoked.", freeBoard);

        int affectedRows = this.mapper.update(freeBoard);
        log.info("\t + affectedRows : {}", affectedRows);

        return (affectedRows == 1);
    }

    @Override
    public boolean remove(Integer frefer) {
        log.debug("remove({}) invoked.", frefer);
        return false;
    }

    @Override
    public FreeBoardVO get(Integer frefer) {
        return null;
    }

    @Override
    public List<FreeBoardVO> getList() {
        return null;
    }

    @Override
    public List<FreeBoardVO> getListPerPage(Criteria criteria) {
        return null;
    }

    @Override
    public Integer getTotal() {
        return null;
    }

    // 1. 새로운 게시글 요청


}
