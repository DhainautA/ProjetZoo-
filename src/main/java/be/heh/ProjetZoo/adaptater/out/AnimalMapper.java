package be.heh.ProjetZoo.adaptater.out;

import be.heh.ProjetZoo.model.Animal;

import java.util.ArrayList;
import java.util.List;


public class AnimalMapper {

    List<Animal> mapToDomainEntity(List<AnimalJpaEntity> animals){
        List<Animal> animalsList= new ArrayList<>();

        for(AnimalJpaEntity animalJpaEntity: animals){
            animalsList.add(new Animal(animalJpaEntity.getId(),animalJpaEntity.getName(), animalJpaEntity.getCategory(), animalJpaEntity.getPrice()));
        }
        return animalsList;

    }

    Animal mapToSingleEntity(AnimalJpaEntity animal) {
        return new Animal(animal.getId(),animal.getName(), animal.getCategory(), animal.getPrice());
    }

}
