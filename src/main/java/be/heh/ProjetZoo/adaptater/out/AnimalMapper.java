package be.heh.ProjetZoo.adaptater.out;

import be.heh.ProjetZoo.model.Animal;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


public class AnimalMapper {

    List<Animal> mapToDomainEntity(List<AnimalJpaEntity> animals){
        List<Animal> animalsList= new ArrayList<>();

        for(AnimalJpaEntity animalJpaEntity: animals){
            animalsList.add(new Animal(animalJpaEntity.getName(), animalJpaEntity.getCategory(), animalJpaEntity.getPrice()));
        }
        return animalsList;

    }
}
