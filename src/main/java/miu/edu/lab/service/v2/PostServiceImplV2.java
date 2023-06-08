package miu.edu.lab.service.v2;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.dto.v2.PostDtoV2;
import miu.edu.lab.utils.ListMapper;
import miu.edu.lab.repo.v2.PostRepoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImplV2 implements PostServiceV2 {

    private final PostRepoV2 postRepoV2;

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<PostDtoV2> getPostsByAuthor(String author) {
        return (List<PostDtoV2>) listMapper.mapList(this.postRepoV2.getPostsByAuthor(author), new PostDtoV2());
    }
}
