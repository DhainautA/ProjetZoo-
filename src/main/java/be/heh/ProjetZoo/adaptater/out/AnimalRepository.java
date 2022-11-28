package be.heh.ProjetZoo.adaptater.out;

import be.heh.ProjetZoo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AnimalRepository extends JpaRepository<AnimalJpaEntity,Long> {
}
