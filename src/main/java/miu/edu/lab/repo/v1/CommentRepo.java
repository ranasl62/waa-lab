package miu.edu.lab.repo.v1;

import miu.edu.lab.domain.v1.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity, Long> {

}
