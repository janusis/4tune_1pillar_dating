package sajudating.jpadating.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class Comment {

    @Id @GeneratedValue
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


    //그룹 그룹으로 묶기
    private Long groupNum;
    //뎁스 -> 깊이
    private Long hierarchy;
    //내림차순 정렬 (pubTime 으로 내림차순)
    private Long orders;

    private LocalDateTime pubTime;
    private LocalDateTime modTime;

    private Long good;
    private Long bad;

//    @OneToMany(mappedBy = "commentId")
//    private List<ReportComment> reportCommentList=new ArrayList<>();

    private Long reportCount;

    private void changeCommentNull(){
        if(member!=null){
            this.member=null;
        }
    }

    public void deleteComment(){
        changeCommentNull();
    }

}
