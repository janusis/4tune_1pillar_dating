package sajudating.jpadating.service;

import com.mysql.cj.jdbc.Clob;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.BoardType;
import sajudating.jpadating.domain.Images;
import sajudating.jpadating.domain.ReportBoard;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.repository.BoardRepository;

import java.time.LocalDateTime;

public class BoardService {
    private final BoardRepository boardRepository ;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    //게시글 저장
    public Long write(BoardDTO boardDTO) {
        String title, Member member, LocalDateTime pubTime, LocalDateTime modTime,
                Clob context, Long views, Long good, Long bad, BoardType boardType,
                List<Images> imagesBoardList, List<ReportBoard> reportBoardList, Long reportConut
        new Board(boardDTO.getTitle(),boardDTO.getMember(),boardDTO.getPubTime(),boardDTO.getModTime(),
                boardDTO.getContext(),0,0,0,boardDTO.getBoardType(),boardDTO.getImagesBoardList(),
                );

        boardRepository.save();

    }
    //게시글 전체 조회

    //게시글 수정

    //게시글 삭제

}
