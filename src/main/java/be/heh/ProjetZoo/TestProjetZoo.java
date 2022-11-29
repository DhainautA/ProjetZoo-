package be.heh.ProjetZoo;

import be.heh.ProjetZoo.adaptater.out.AnimalMapper;
import be.heh.ProjetZoo.adaptater.out.AnimalPersistenceAdapter;
import be.heh.ProjetZoo.adaptater.out.AnimalRepository;
import be.heh.ProjetZoo.port.in.AnimalListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestProjetZoo {

    public static void main(String[] args) {
        SpringApplication.run(TestProjetZoo.class, args);
    }

}
