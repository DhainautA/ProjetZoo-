package be.heh.ProjetZoo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class Animal {
    @Getter
    private final long id;

    @Getter
     private final String name;

    @Getter
    private final String category;

    @Getter
    private final float price;
}


