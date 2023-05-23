package com.green.board7.model;

import lombok.Data;

@Data
public class BoardDto extends BoardEntity {
    private int page;
    private int startIdx;
    private int rowLen;
}
