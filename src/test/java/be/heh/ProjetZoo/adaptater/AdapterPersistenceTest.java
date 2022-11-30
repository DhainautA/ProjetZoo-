package be.heh.ProjetZoo.adaptater;

import be.heh.ProjetZoo.adaptater.out.AnimalMapper;
import be.heh.ProjetZoo.adaptater.out.AnimalPersistenceAdapter;
import be.heh.ProjetZoo.adaptater.out.AnimalRepository;
import be.heh.ProjetZoo.model.Animal;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class AdapterPersistenceTest extends AbstractIntegrationTest {

    @Autowired
    private AnimalRepository animalRepository;
    private AnimalMapper animalMapper;

    private AnimalPersistenceAdapter animalPersistenceAdapter;

    @Test
    @Sql({"AnimalTablecreate.sql","list.sql"})
    void getAnimalList(){
        animalMapper = new AnimalMapper();
        animalPersistenceAdapter = new AnimalPersistenceAdapter(animalRepository,animalMapper);

        List<Animal> animals;

        animals = animalPersistenceAdapter.getAnimalList();

        assertEquals("chat",animals.get(0).getName());
        assertEquals("felin",animals.get(0).getCategory());
        assertEquals(20,animals.get(0).getPrice());
    }
}
