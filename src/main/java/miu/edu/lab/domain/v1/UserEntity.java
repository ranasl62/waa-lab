package miu.edu.lab.domain.v1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab.domain.v1.common.BaseDomain;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<PostEntity> postEntities;

    public PostEntity findPostById(long postId) {
        return postEntities.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElse(null);
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
