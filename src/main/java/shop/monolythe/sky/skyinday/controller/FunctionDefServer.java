package shop.monolythe.sky.skyinday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.monolythe.sky.skyinday.dto.FunctionDefDto;
import shop.monolythe.sky.skyinday.entity.FunctionDef;
import shop.monolythe.sky.skyinday.repository.FunctionDefRepository;
import shop.monolythe.sky.skyinday.service.FunctionDefService;

import java.util.List;

@RestController
@RequestMapping("/api/functions")
public class FunctionDefServer {
    @Autowired
    private FunctionDefService svc;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FunctionDefDto dto,
                                    @RequestHeader("X-User") String user) {
        FunctionDef f = svc.create(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(f);
    }

    @GetMapping
    public List<FunctionDef> list() {
        return svc.listAll();
    }
}

