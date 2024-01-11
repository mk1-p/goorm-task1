package com.example.webdockerbuild.boards;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public ResponseEntity getBoards() {
        List<BoardDto> boards = boardService.getBoards();
        return ResponseEntity.ok().body(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBoard(@PathVariable Long id) {
        BoardDto board = boardService.getBoard(id);
        return ResponseEntity.ok().body(board);
    }

    @PostMapping()
    public ResponseEntity saveBoard(@RequestBody BoardDto board) {
        boardService.createBoard(board);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }


}
