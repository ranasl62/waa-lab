package miu.edu.lab1.repo.v1;

import miu.edu.lab1.domain.v1.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
