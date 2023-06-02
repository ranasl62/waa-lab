package miu.edu.lab.service.v1;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.User;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.dto.v1.UserDto;
import miu.edu.lab.helper.ListMapper;
import miu.edu.lab.repo.v1.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapper.mapList(this.userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(this.userRepo.getById(id), UserDto.class);
    }

    @Override
    public void create(User p) {
        this.userRepo.save(p);
    }

    @Override
    public void delete(long id) {
        this.userRepo.delete(this.userRepo.findById(id).get());
    }

    @Override
    public void update(long id, User p) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(p.getName());
            userRepo.save(user);
        }
    }

    @Override
    public List<PostDto> getPostByUserId(long id) {
        this.userRepo.getById(id).getPosts().forEach(System.out::println);
        return (List<PostDto>) listMapper.mapList(this.userRepo.getById(id).getPosts(), new PostDto());
    }

    @Override
    public List<UserDto> getUsersWithMultiplePosts() {
        return (List<UserDto>) listMapper.mapList(this.userRepo.getUsersWithMultiplePosts(), new UserDto());
    }
}
