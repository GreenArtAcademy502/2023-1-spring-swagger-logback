package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int insBoardCmt(BoardCmtInsDto dto);
}
