package sajudating.jpadating.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.repository.BoardRepository;

@SpringBootTest
@Transactional
public class boardRepoTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void 쿼리테스트(){
        Long maxRowNum = boardRepository.findMaxRowNum();
        System.out.println("------------------------------------------------------------" + maxRowNum);
    }
}
