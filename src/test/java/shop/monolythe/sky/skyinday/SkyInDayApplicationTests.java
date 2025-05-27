package shop.monolythe.sky.skyinday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import shop.monolythe.sky.skyinday.entity.FunctionDef;
import shop.monolythe.sky.skyinday.repository.FunctionDefRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class SkyInDayApplicationTests {
    @Autowired
    private FunctionDefRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    void testFunctionDefCrud() {
        FunctionDef f = new FunctionDef();
        f.setName("test-func");
        f.setDescription("desc");
        f.setCode("code");
        f.setCreatedBy("tester");
        f.setCreatedAt(java.time.Instant.now());
        FunctionDef saved = repo.save(f);
        assertNotNull(saved.getId());

        Optional<FunctionDef> found = repo.findByName("test-func");
        assertTrue(found.isPresent());
        assertEquals("desc", found.get().getDescription());

        repo.delete(saved);
        assertFalse(repo.findByName("test-func").isPresent());
    }
}
