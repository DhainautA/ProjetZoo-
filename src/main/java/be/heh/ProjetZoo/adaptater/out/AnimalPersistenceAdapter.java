package be.heh.ProjetZoo.adaptater.out;

import be.heh.ProjetZoo.model.Animal;
import be.heh.ProjetZoo.port.in.AnimalListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class AnimalPersistenceAdapter implements AnimalListUseCase {

    private final AnimalRepository animalRepository;
    private List<Animal> animals;

    private final AnimalMapper animalMapper;

    @Override
    public List<Animal> getAnimalList() {
        List<AnimalJpaEntity> animalEntity = animalRepository.findAll();
        return animalMapper.mapToDomainEntity(animalEntity);
    }
}
