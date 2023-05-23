package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
