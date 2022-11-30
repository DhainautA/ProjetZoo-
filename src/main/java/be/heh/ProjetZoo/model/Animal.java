package be.heh.ProjetZoo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class Animal {

    @Getter
    private final String name;

    @Getter
    private final String category;

    @Getter
    private final Float price;

}
