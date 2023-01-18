package be.heh.ProjetZoo.adaptater.in;

import be.heh.ProjetZoo.model.Animal;
import be.heh.ProjetZoo.port.in.AnimalListUseCase;
import be.heh.ProjetZoo.port.in.AnimalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("animal", new Animal(0,"","",0F));
        return "aAnimal";
    }

   @PostMapping("/addAnimal")
    public String aAnimal(@ModelAttribute Animal animal,Model model){
       model.addAttribute(animal);
       animalUseCase.addAnimal(animal);
       return "redirect:/";
   }

    @RequestMapping(value="/mAnimal/{animalId}", method=RequestMethod.GET)
    public String modAnimal(@PathVariable Long animalId, Model model){
        Animal animal = animalUseCase.getAnimal(animalId);
        model.addAttribute(animal);
        return "modAnimal";
    }

    @RequestMapping(value="/modAnimal/{animalId}", method=RequestMethod.POST)
    public String modAnimal(@PathVariable Long animalId, @ModelAttribute Animal animal, Model model){
        animalUseCase.modifyAnimal(animalId, animal);
        model.addAttribute(animal);
        return "animalList";
    }

    @RequestMapping(value="/deleteAnimal/{animalId}", method=RequestMethod.GET)
    public String deleteAnimal(@PathVariable Long animalId, Model model){
        animalUseCase.deleteAnimal(animalId);
        return "redirect:/";
    }


}
