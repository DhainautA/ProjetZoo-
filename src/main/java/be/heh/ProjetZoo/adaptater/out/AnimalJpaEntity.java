package be.heh.ProjetZoo.adaptater.out;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table (name = "animals")

public class AnimalJpaEntity {

    public AnimalJpaEntity(long id, String name, String category, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public AnimalJpaEntity(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="category")
    private String category;

    @Column(name = "price")
    private float price;
}
