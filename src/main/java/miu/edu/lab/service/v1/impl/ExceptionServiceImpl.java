package miu.edu.lab.service.v1.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.ExceptionEntity;
import miu.edu.lab.repo.v1.ExceptionRepo;
import miu.edu.lab.service.v1.ExceptionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExceptionServiceImpl implements ExceptionService {

    private final ExceptionRepo exceptionRepo;

    @Override
    public void create(ExceptionEntity exception) {
        this.exceptionRepo.save(exception);
    }

    @Override
    public List<ExceptionEntity> findAll() {
        return exceptionRepo.findAll();
    }

    @Override
    public ExceptionEntity getById(long id) {
        Optional<ExceptionEntity> exceptionEntity = exceptionRepo.findById(id);
        return exceptionEntity.orElse(null);
    }
}
