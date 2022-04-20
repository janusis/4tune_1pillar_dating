package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.MemberRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository boardRepository ;
    private final MemberRepository memberRepository;

    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository) {

        this.boardRepository = boardRepository;
        this.memberRepository= memberRepository;
    }


    //게시글 저장
    @Transactional(readOnly = false)
    public Long writeBoard(@NotNull BoardDTO boardDTO) {
        Member member = memberRepository.findById(boardDTO.getMemberId());

        Board board = new Board(boardDTO.getTitle(), member, boardDTO.getPubTime(), boardDTO.getPubTime(),
                boardDTO.getContext(), 0L, 0L, 0L, boardDTO.getBoardType(),
                0L
        );
        boardRepository.save(board);
        return board.getId();
    }
    //게시글 전체 조회
    @Transactional
    public List<BoardDTO> findBoards(){
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(BoardDTO::new)
                .collect(Collectors.toList());

    }

    //게시글 수정
    @Transactional
    public Long changeBoard(BoardDTO boardDTO){
        Board board = boardRepository.findByMemberIdAndPubTime(boardDTO);
        board.updateBoard(boardDTO);
        return boardRepository.change(board);
    }

    //게시글 삭제
    @Transactional
    public Long deleteBoard(Long boardId){
        boardRepository.delete(boardId);
        return boardId;
    }
}
