package com.green.board7.board;

import com.green.board7.board.model.BoardDetailVo;
import com.green.board7.board.model.BoardDto;
import com.green.board7.board.model.BoardInsDto;
import com.green.board7.board.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public List<BoardVo> selBoardAll(BoardDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRowLen();
        dto.setStartIdx(startIdx);
        return mapper.selBoardAll(dto);
    }

    public BoardDetailVo selBoardById(BoardDto dto) {
        return mapper.selBoardById(dto);
    }

    public int updBoard(BoardDto dto) {
        return mapper.updBoard(dto);
    }

    public int delBoard(BoardDto dto) {
        return mapper.delBoard(dto);
    }
}
