package shop.monolythe.sky.skyinday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.monolythe.sky.skyinday.dto.FunctionDefDto;
import shop.monolythe.sky.skyinday.entity.FunctionDef;
import shop.monolythe.sky.skyinday.repository.FunctionDefRepository;

import java.time.Instant;
import java.util.List;

@Service
public class FunctionDefService {
    @Autowired
    private FunctionDefRepository repo;

    public FunctionDef create(FunctionDefDto dto, String user) {
        if (repo.findByName(dto.name).isPresent()){
            throw new RuntimeException("函数名已存在");
        }
        FunctionDef f = new FunctionDef();
        f.setName(dto.name);
        f.setDescription(dto.description);
        f.setCode(dto.code);
        f.setCreatedBy(user);
        f.setCreatedAt(Instant.now());
        return repo.save(f);
    }

    public List<FunctionDef> listAll() {
        return repo.findAll();
    }
}

