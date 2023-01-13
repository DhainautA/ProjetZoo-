package be.heh.ProjetZoo.adaptater.in;

import be.heh.ProjetZoo.model.Animal;
import be.heh.ProjetZoo.port.in.AnimalListUseCase;
import be.heh.ProjetZoo.port.in.AnimalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequiredArgsConstructor

public class AnimalController {

    private final AnimalUseCase animalUseCase;
    private List<Animal> animals;


    @GetMapping ("/")
    public String animalList(Model model){
    animals = animalUseCase.getAnimalList();
    model.addAttribute("animals",animals);

    return "animalList";

    }

    @GetMapping("/aAnimal")
    public String aAnimal(Model model){
        model.addAttribute("animals", new Animal(0,"","",null));
        return "aAnimal";
    }

   @PostMapping("/aAnimal")
    public String aAnimal(@ModelAttribute Animal animal,Model model){
       animalUseCase.addAnimal(animal);
       return "redirect:/";
   }













}
