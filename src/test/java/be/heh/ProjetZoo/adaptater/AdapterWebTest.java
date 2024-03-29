package be.heh.ProjetZoo.adaptater;


import be.heh.ProjetZoo.adaptater.in.AnimalController;
import be.heh.ProjetZoo.model.Animal;
import be.heh.ProjetZoo.port.in.AnimalUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(AnimalController.class)
public class AdapterWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalUseCase animalUseCase;

    private List<Animal>animals = new ArrayList<>();

    @Test
    public void testAnimalController() throws Exception {

        animals.add(new Animal(0L,"chat", "Domestique",15.0F));
        animals.add(new Animal(1L,"chien","Domestique",15.0F));
        animals.add(new Animal(2L,"baleine","aquatique",200.0F));

        //Stub
        Mockito.when(animalUseCase.getAnimalList()).thenReturn(animals);

       mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("animalList"))
                .andExpect(model().attributeExists("animals"))
                .andExpect(model().attribute("animals",Matchers.hasSize(3)));


    }
}
