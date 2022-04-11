package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.repository.BoardRepository;

import javax.transaction.Transactional;

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
                boardDTO.getImagesBoardList(), boardDTO.getReportBoardList(), boardDTO.getReportConut()
        );
        boardRepository.save(board);
        return board.getId();
    }
    //게시글 전체 조회


    //게시글 수정

    //게시글 삭제

}
