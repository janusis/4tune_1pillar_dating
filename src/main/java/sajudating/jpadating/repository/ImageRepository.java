package sajudating.jpadating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sajudating.jpadating.domain.Image;

import javax.persistence.EntityManager;

@Repository
public class ImageRepository  {

    private final EntityManager em;

    public ImageRepository(EntityManager em) {
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
    public Image findByFileName(String fileName) {
        return em.createQuery("select i from image i where i.fileName = :fileName", Image.class).setParameter("fileName", fileName).getSingleResult();
    }


    //pk로 이미지 찾기
    public Image findById(Long id){
        return em.find(Image.class, id);
    }

    //이미지 저장

    public Long save(Image image){
        em.persist(image);
        return image.getId();
    }

    //이미지 조회

    //이미지 수정

    //이미지 삭제


    //확장자 추출
    public String extract(String originalFilename) {
        int idx = originalFilename.lastIndexOf(".");
        String ext = originalFilename.substring(idx);
        return ext;
    }

}
