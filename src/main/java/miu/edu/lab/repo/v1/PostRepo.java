package miu.edu.lab.repo.v1;

import miu.edu.lab.domain.v1.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByTitle(String title);
}
