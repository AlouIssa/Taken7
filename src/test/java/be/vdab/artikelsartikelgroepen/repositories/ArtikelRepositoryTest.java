package be.vdab.artikelsartikelgroepen.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Sql({"/insertArtikelGroepen.sql", "/insertArtikelen.sql"})
class ArtikelRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final ArtikelRepository repository;
    ArtikelRepositoryTest(ArtikelRepository repository) {
        this.repository = repository;
    }

    @Test
    void findHoogstePrijs(){
        assertThat(repository.findHoogstePrijs()).isEqualTo(90);
    }
    @Test
    void findByPrijsBetween(){
        var lijst = repository.findByPrijsBetween(BigDecimal.ONE, BigDecimal.valueOf(50));
        assertThat(lijst.get(0).getPrijs()).isOne();
    }
    @Test
    void findByPrijsGreaterThanEqual(){
        assertThat(repository.findByPrijsGreaterThanEqual(BigDecimal.TEN)).hasSize(2);
    }
    @Test
    void findByNaam(){
        assertThat(repository.findByNaam("stoel").get().getPrijs()).isEqualByComparingTo("30");
    }

}