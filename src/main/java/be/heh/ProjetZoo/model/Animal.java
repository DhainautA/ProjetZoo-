package be.heh.ProjetZoo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class Animal {

    @Getter
    private final String nom;

    @Getter
    private final String catégorie;

    @Getter
    private final Float prix;

}
