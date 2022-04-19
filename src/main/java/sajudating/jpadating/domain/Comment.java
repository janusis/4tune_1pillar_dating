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


    //댓글 출력하는 법
    //1. 그룹 별로 나누기
    //2. 0 뎁스부터 출력 그리고 0뎁스와 관련된 1뎁스가 있으면 출력

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
