package com.green.board7;

import com.green.board7.model.BoardDetailVo;
import com.green.board7.model.BoardDto;
import com.green.board7.model.BoardInsDto;
import com.green.board7.model.BoardVo;
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
        final int ROW_PER_PAGE = 30;
        int startIdx = (dto.getPage() - 1) * ROW_PER_PAGE;
        dto.setStartIdx(startIdx);
        dto.setRowLen(ROW_PER_PAGE);

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
