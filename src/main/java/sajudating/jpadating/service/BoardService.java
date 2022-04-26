package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.BoardDTO;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.MemberRepository;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    private final BoardRepository boardRepository ;
    private final MemberRepository memberRepository;
    private final ImagesService imagesService;

    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository, ImagesService imagesService) {

        this.boardRepository = boardRepository;
        this.memberRepository= memberRepository;
        this.imagesService = imagesService;
    }


    //게시글 저장
    @Transactional(readOnly = false)
    public Long writeBoard(@NotNull BoardDTO boardDTO, List<MultipartFile> image) {

        Member member = memberRepository.findById(boardDTO.getMemberId());
        //게시글 번호 넘버링
        Long maxRowNum = boardRepository.findMaxRowNum();


        // 게시글을 저장한다
        Board board=Board.builder().
                rowNum(maxRowNum).
                title(boardDTO.getTitle()).
                member(member).
                pubTime(LocalDateTime.now()).
                modTime(LocalDateTime.now()).
                context(boardDTO.getContext()).
                boardType(boardDTO.getBoardType()).
                views(0L).
                good(0L).bad(0L).reportCount(0L).build();

        Long id = boardRepository.save(board);

        //2. 게시판에 첨부된 파일을 저장한다.
        imagesService.saveImage(image,id);



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

    //게시글 단건 조회
    @Transactional
    public BoardDTO findBoard(Long id){
        Board board = boardRepository.findById(id);
        return new BoardDTO(board);
    }

    //게시글 수정
    @Transactional
    public Long changeBoard(Long id,BoardDTO boardDTO, List<MultipartFile> image){

        Board board = boardRepository.findById(id);
        board.updateBoard(boardDTO);
        Long boardId = boardRepository.change(board);
        imagesService.saveImage(image,id);
        return boardId;
    }

    //게시글 삭제
    @Transactional
    public Long deleteBoard(Long boardId){
        boardRepository.delete(boardId);
        return boardId;
    }


}
