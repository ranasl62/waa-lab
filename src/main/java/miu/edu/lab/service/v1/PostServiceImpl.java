package miu.edu.lab.service.v1;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.Post;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.helper.ListMapper;
import miu.edu.lab.repo.v1.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(this.postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(this.postRepo.getById(id), PostDto.class);
    }

    @Override
    public void create(Post p) {
        this.postRepo.save(p);
    }

    @Override
    public void delete(long id) {
        this.postRepo.delete(this.postRepo.findById(id).get());
    }

    @Override
    public void update(long id, Post p) {
        this.update(id, p);
    }
}
