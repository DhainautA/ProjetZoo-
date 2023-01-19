package be.heh.ProjetZoo.port.in;

import be.heh.ProjetZoo.model.Animal;
import java.util.List;


public interface AnimalUseCase {


    List<Animal> getAnimalList();

    Animal getAnimal(Long id);

    void addAnimal(Animal animal);

    void modifyAnimal(Long id,Animal animal);

    void deleteAnimal(Long id);

    boolean isAdmin(String email);


}
