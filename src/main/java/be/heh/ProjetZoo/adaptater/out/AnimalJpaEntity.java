package be.heh.ProjetZoo.adaptater.out;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table (name = "animals")

public class AnimalJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "animalid")
    private Long animalid;

    @Column(name = "name")
    private String name;

    @Column(name="category")
    private String category;

    @Column(name = "price")
    private Float price;
}
