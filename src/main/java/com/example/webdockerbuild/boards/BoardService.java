package com.example.webdockerbuild.boards;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(BoardDto boardDto) {
        Board board = Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();

        boardRepository.save(board);
    }

    public BoardDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시물이 없습니다."));
        return BoardDto.toDto(board);
    }
    public List<BoardDto> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardDto::toDto).collect(Collectors.toList());
    }


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
