package sajudating.jpadating.comment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sajudating.jpadating.repository.CommentRepository;

@SpringBootTest
@Transactional

public class CommentRepoTest {

    @Autowired
    private CommentRepository commentRepository;


}
