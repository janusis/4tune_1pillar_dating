package sajudating.jpadating.repository;

import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Images;

import javax.persistence.EntityManager;
import javax.persistence.FieldResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class ImagesRepository {

    private final EntityManager em;

    public ImagesRepository(EntityManager em) {
        this.em = em;
    }

    public Long findMaxId(){
        Object id = em.createQuery("select max(i.Id) from Image i").getSingleResult();
        if(id!=null){
            return (Long) id+1;
        }else{
            return 0L;
        }
    }
    public Images findByFileName(String fileName) {
        return em.createQuery("select i from Images i where i.fileName = :fileName", Images.class).
                setParameter("fileName", fileName).getSingleResult();
    }


    //pk로 이미지 찾기
    public Images findById(Long id){
        return em.find(Images.class, id);
    }

    //이미지 저장

    public Long save(Images images){
        em.persist(images);
        return images.getId();
    }

    //이미지 조회

    //이미지 수정

    //이미지 삭제
    public Long delete(Long imagesId) throws IOException {
        Images images = findById(imagesId);
        String filePath = images.getFilePath();
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
        em.remove(images);
        return imagesId;
    }


    //확장자 추출
    public String extract(String originalFilename) {
        int idx = originalFilename.lastIndexOf(".");
        String ext = originalFilename.substring(idx);
        return ext;
    }

}
