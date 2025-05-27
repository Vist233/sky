package shop.monolythe.sky.skyinday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.monolythe.sky.skyinday.entity.FunctionDef;
import java.util.Optional;

public interface FunctionDefRepository extends JpaRepository<FunctionDef, Long> {
    Optional<FunctionDef> findByName(String name);
}

