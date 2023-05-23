package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtDelDto;
import com.green.board7.cmt.model.BoardCmtDto;
import com.green.board7.cmt.model.BoardCmtInsDto;
import com.green.board7.cmt.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoardCmt(BoardCmtInsDto dto) {
        return mapper.insBoardCmt(dto);
    }
    public List<BoardCmtVo> selBoardCmt(BoardCmtDto dto) {
        return mapper.selBoardCmt(dto);
    };
    public int delBoardCmt(BoardCmtDelDto dto) {
        return mapper.delBoardCmt(dto);
    }
}
