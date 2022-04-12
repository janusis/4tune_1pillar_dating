package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository boardRepository ;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    //게시글 저장
    @Transactional
    public Long write(BoardDTO boardDTO) {
        Board board = new Board(boardDTO.getTitle(), boardDTO.getMember(), boardDTO.getPubTime(), boardDTO.getModTime(),
                boardDTO.getContext(), 0L, 0L, 0L, boardDTO.getBoardType(),
                boardDTO.getReportConut()
        );
        boardRepository.save(board);
        return board.getId();
    }
    //게시글 전체 조회
    @Transactional
    public List<BoardDTO> findBoards(){
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(b -> new BoardDTO(b.getId(),
                        b.getTitle(),
                        b.getMember(),
                        b.getPubTime(),
                        b.getModTime(),
                        b.getContext(),
                        b.getViews(),
                        b.getGood(),
                        b.getBad(),
                        b.getBoardType(),
                        b.getReportConut()))
                .collect(Collectors.toList());

    }

    //게시글 수정
    @Transactional
    public Long changeBoardInfo(BoardDTO boardDTO){
        Board board = boardRepository.findByMemberIdAndPubTime(boardDTO);
        board.updateBoard(boardDTO);
        return boardRepository.change(board);
    }

    //게시글 삭제

}
