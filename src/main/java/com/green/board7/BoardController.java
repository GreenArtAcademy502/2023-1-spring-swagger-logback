package com.green.board7;


import com.green.board7.model.BoardDetailVo;
import com.green.board7.model.BoardDto;
import com.green.board7.model.BoardInsDto;
import com.green.board7.model.BoardVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name="게시판", description = "ddddd")
@RestController
@Validated
@RequestMapping("/")
public class BoardController {
    private final Logger LOGGER;
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        LOGGER = LoggerFactory.getLogger(BoardController.class);
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글등록", description = "" +
            "title(string) : 제목 <br>\n" +
            "ctnt(string) : 내용<br>\n" +
            "wrtier(string) : 작성자")
    public int postBoard(@RequestBody BoardInsDto dto) {
        LOGGER.warn("경고, 글 등록이 됩니다.");
        return service.insBoard(dto);
    }

    @GetMapping
    public List<BoardVo> getBoard(@RequestParam int page) {
        LOGGER.info("page : " + page);
        BoardDto dto = new BoardDto();
        dto.setPage(page);
        return service.selBoardAll(dto);
    }

    @GetMapping("/{iboard}")
    public BoardDetailVo getBoardById(@PathVariable int iboard) {
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        LOGGER.info(dto.toString());
        return service.selBoardById(dto);
    }

    @PutMapping
    public int putBoard(@RequestBody BoardDto dto) {
        return service.updBoard(dto);
    }

    @DeleteMapping("/{iboard}")
    public int deleteBoard(@PathVariable int iboard) {
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        return service.delBoard(dto);
    }
}
