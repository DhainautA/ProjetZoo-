package be.heh.ProjetZoo.adaptater.out;

import be.heh.ProjetZoo.model.Animal;
import be.heh.ProjetZoo.port.in.AnimalUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AnimalPersistenceAdapter implements AnimalUseCase {

    private final AnimalRepository animalRepository;
    private List<Animal> animals;

    private final AnimalMapper animalMapper;

    @Override
    public List<Animal> getAnimalList() {
        List<AnimalJpaEntity> animalEntity = animalRepository.findAll();
        return animalMapper.mapToDomainEntity(animalEntity);
    }
    public Animal getAnimal(Long id){
        AnimalJpaEntity selectedAnimal = animalRepository.getReferenceById(id);
        return animalMapper.mapToSingleEntity(selectedAnimal);
    }
    @Override
    public void addAnimal(Animal animal){
        AnimalJpaEntity animalEntity = new AnimalJpaEntity();
        animalEntity.setName(animal.getName());
        animalEntity.setCategory(animal.getCategory());
        animalEntity.setPrice(animal.getPrice());
        animalRepository.save(animalEntity);

    }

    @Override
    public void modifyAnimal(Long id, Animal animal) {
        AnimalJpaEntity selectedAnimal = animalRepository.getReferenceById(id);
        selectedAnimal.setName(animal.getName());
        selectedAnimal.setCategory(animal.getCategory());
        selectedAnimal.setPrice(animal.getPrice());
        animalRepository.save(selectedAnimal);

    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public boolean isAdmin(String email) {
        final List<String> admins = List.of("administrator@gmail.com","dhainaut.antoine98@gmail.com");
        if(admins.contains(email)){
            return true;
        }
        return false;
    }


}
