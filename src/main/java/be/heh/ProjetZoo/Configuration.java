package be.heh.ProjetZoo;

import be.heh.ProjetZoo.adaptater.out.AnimalMapper;
import be.heh.ProjetZoo.adaptater.out.AnimalPersistenceAdapter;
import be.heh.ProjetZoo.adaptater.out.AnimalRepository;
import be.heh.ProjetZoo.port.in.AnimalListUseCase;
import be.heh.ProjetZoo.port.in.AnimalUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories

public class Configuration {
    @Autowired
    private AnimalRepository animalRepository;
    private AnimalMapper animalMapper = new AnimalMapper();

    @Bean
    AnimalUseCase getAnimalList(){

    return new AnimalPersistenceAdapter(animalRepository,animalMapper);
    }





}
