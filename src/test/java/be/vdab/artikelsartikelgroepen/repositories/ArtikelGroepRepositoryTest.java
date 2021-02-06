package be.vdab.artikelsartikelgroepen.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Sql("/insertArtikelGroepen.sql")
class ArtikelGroepRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final ArtikelGroepRepository repository;
    ArtikelGroepRepositoryTest(ArtikelGroepRepository repository) {
        this.repository = repository;
    }

    @Test
    void een(){
        assertThat(repository.count()).isEqualTo(2);
    }
    @Test
    void findByNaam(){
        assertThat(repository.findByNaam("food").get().getNaam()).isNotEqualTo("non-food");
        assertThat(repository.findByNaam("food")).isPresent();
        assertThat(repository.findByNaam("ok")).isNotPresent();
    }
}