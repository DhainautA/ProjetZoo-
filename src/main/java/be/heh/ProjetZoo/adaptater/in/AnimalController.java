package be.heh.ProjetZoo.adaptater.in;

import be.heh.ProjetZoo.model.Animal;
import be.heh.ProjetZoo.port.in.AnimalListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class AnimalController {

    private final AnimalListUseCase animalListUseCase;
    private List<Animal> animals;

    @GetMapping ("/")
    public String animalList(Model model){
    animals = animalListUseCase.getAnimalList();
    model.addAttribute("animals",animals);

    return "animalList";
    }




}
