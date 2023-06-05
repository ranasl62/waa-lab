package miu.edu.lab.service.v1;

import miu.edu.lab.domain.v1.ExceptionEntity;

import java.util.List;

public interface ExceptionService {
    void create(ExceptionEntity exception);

    public List<ExceptionEntity> findAll();

    public ExceptionEntity getById(long id);
}
