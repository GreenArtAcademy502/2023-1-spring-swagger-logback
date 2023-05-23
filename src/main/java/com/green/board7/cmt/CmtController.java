package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/cmt")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    public int postBoardCmt(@RequestBody BoardCmtInsDto dto) {
        return service.insBoardCmt(dto);
    }

}
