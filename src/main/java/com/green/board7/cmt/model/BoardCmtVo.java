package com.green.board7.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardCmtVo {
    private int icmt;
    private String ctnt;
    private String writer;
    private String createdAt;
}
