package sajudating.jpadating.domainDto;

import lombok.Data;
import sajudating.jpadating.domain.Comment;
import sajudating.jpadating.domain.DeleteStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDTO {

    private Long id;
    private String context;

    //member 에서 가져오는 것들
    private Long memberId;
    private String memberNickname;


    //board 에서 가져오는 것들
    private Long boardId;

    @Enumerated(value = EnumType.STRING)
    private DeleteStatus isDeleted;


    private Long parentId;

    private List<CommentDTO> children = new ArrayList<>();

//    private List<Comment> children = new ArrayList<>();

    private LocalDateTime pubTime;
    private LocalDateTime modTime;
    private Long good;
    private Long bad;
    private Long reportCount;

    protected CommentDTO(){

    }

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.context = comment.getContext();
        this.memberId = comment.getMember().getId();
        this.memberNickname = comment.getMember().getNickname();
        this.boardId = comment.getBoards().getId();
        this.isDeleted = comment.getIsDeleted();
        if(comment.getParent()!=null){
            this.parentId = comment.getParent().getId();
        }else{
            this.parentId=null;
        }

        if(!comment.getChildren().isEmpty()){
            comment.getChildren().
                    stream().
                    forEach(c->{
                        this.children.add(new CommentDTO(c));
//                        this.children.add(c);
                    });
        }else{
            this.children = new ArrayList<>();
        }

        this.pubTime = comment.getPubTime();
        this.modTime = comment.getModTime();
        this.good = comment.getGood();
        this.bad = comment.getBad();
        this.reportCount = comment.getReportCount();
    }


}
