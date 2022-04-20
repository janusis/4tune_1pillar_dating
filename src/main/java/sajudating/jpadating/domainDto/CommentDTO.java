package sajudating.jpadating.domainDto;

import lombok.Data;
import lombok.Getter;
import sajudating.jpadating.domain.Board;
import sajudating.jpadating.domain.Comment;
import sajudating.jpadating.domain.DeleteStatus;
import sajudating.jpadating.domain.Member;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CommentDTO {

    private Long id;
    private String context;

    //member 에서 가져오는 것들
    @NotNull
    private Long memberId;
    private String memberNickname;

    //board 에서 가져오는 것들
    @NotNull
    private Long boardId;

    @Enumerated(value = EnumType.STRING)
    private DeleteStatus isDeleted;


    private Long parentId;

    private List<Long> children = new ArrayList<>();

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
        this.boardId = comment.getBoard().getId();
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
                        this.children.add(c.getId());
                    });
        }else{
            this.children = new ArrayList<>();
        }

        this.pubTime = pubTime;
        this.modTime = modTime;
        this.good = good;
        this.bad = bad;
        this.reportCount = reportCount;
    }


}
