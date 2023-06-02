package miu.edu.lab.repo.v1;

import miu.edu.lab.domain.v1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > 1")
    List<User> getUsersWithMultiplePosts();

}
