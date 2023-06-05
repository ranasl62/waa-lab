package miu.edu.lab.repo.v1;

import miu.edu.lab.domain.v1.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE SIZE(u.postEntities) > :postSize")
    List<UserEntity> findByPostsSizeGreaterThan(Long postSize);
    List<UserEntity> findByPostEntitiesTitle(String title);
}
