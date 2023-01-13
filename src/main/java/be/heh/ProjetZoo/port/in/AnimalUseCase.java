package be.heh.ProjetZoo.port.in;

import be.heh.ProjetZoo.model.Animal;

import java.util.List;


public interface AnimalUseCase {



    List<Animal> getAnimalList();

    Animal getAnimal(Long animalid);

    void addAnimal(Animal animal);

    void modifyAnimal(Long animalid,Animal animal);

    void deleteAnimal(Long animalid);




}
