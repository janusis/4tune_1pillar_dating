package sajudating.jpadating.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Comment;
import sajudating.jpadating.domain.DeleteStatus;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.CommentDTO;
import sajudating.jpadating.repository.BoardRepository;
import sajudating.jpadating.repository.CommentRepository;
import sajudating.jpadating.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommentService {

    private final BoardRepository boardRepository ;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public CommentService(BoardRepository boardRepository,
                          MemberRepository memberRepository,
                          CommentRepository commentRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }


    //코멘트 저장

    public Long writeComment(CommentDTO commentDTO){

        Board board = boardRepository.findById(commentDTO.getBoardId());
        Member member = memberRepository.findById(commentDTO.getMemberId());
        Comment parent;

        if(commentDTO.getParentId()!=null)
            parent = commentRepository.findById(commentDTO.getParentId());
        else parent=null;

        Comment comment = new Comment(commentDTO.getContext(),member,board, DeleteStatus.FALSE,parent,
                LocalDateTime.now(),LocalDateTime.now(), 0L,0L,0L);

        Long id = commentRepository.save(comment);

        Comment comment1 = commentRepository.findById(1L);
        System.out.println("  ");
        return id;
    }


    //게시글 별 코멘트 조회

    //게시글정렬 해서 dto에 싹 담기
    public List<CommentDTO> findComments(Long boardId){
        //parentId 와 pubTime을 기준으로 order by 된 리스트
        List<Comment> commentList = commentRepository.findCommentsByBoardId(boardId);
        Map<Long, CommentDTO> map = new HashMap<>();
        List<CommentDTO> result=new ArrayList<>();
        commentList.stream().forEach(
                c->{
                    CommentDTO dto = new CommentDTO(c);
                    map.put(dto.getId(),dto);
                    if(dto.getParentId()!=null) {
//                        CommentDTO parentDTO = map.get(dto.getParentId());
//                        parentDTO.getChildren().add(dto.getId());
                    }else{
                        result.add(dto);
                    }
                }
        );

        return result;
    }



    //코멘트 수정

    //코멘트 삭제


}
