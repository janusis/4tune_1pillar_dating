package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sajudating.jpadating.domainDto.CommentDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "longtext")
    private String context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Enumerated(value = EnumType.STRING)
    private DeleteStatus isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();


    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    private Long good;
    private Long bad;

//    @OneToMany(mappedBy = "commentId")
//    private List<ReportComment> reportCommentList=new ArrayList<>();

    private Long reportCount;


    public Comment(String context, Member member, Board board, DeleteStatus isDeleted, Comment parent,
                   LocalDateTime pubTime, LocalDateTime modTime, Long good, Long bad, Long reportCount) {
        this.context = context;
        this.member = member;
        this.board = board;
        this.isDeleted = isDeleted;
        this.parent = parent;
        this.pubTime = pubTime;
        this.modTime = modTime;
        this.good = good;
        this.bad = bad;
        this.reportCount = reportCount;
    }

    public void changeContext(String context){
        if( context != null)
            this.context=context;
    }

    public void changeDeleteStatus(DeleteStatus isDeleted){
        if( context != null)
            this.isDeleted = isDeleted;
    }

    public void changeModTime(){
        this.modTime = LocalDateTime.now();
    }

    public void updateComment(CommentDTO commentDTO){
        changeContext(commentDTO.getContext());
        changeModTime();
//        changeDeleteStatus(commentDTO.getIsDeleted());
    }


    private void changeCommentMemberNull(){
        if(member!=null){
            this.member=null;
        }
    }

    public void deleteCommentMember(){
        changeCommentMemberNull();
    }




}
