package Infrastructure;


import Domain.PersonEntity;
import Domain.PersonRepository;
import Domain.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControladorPerson {

    @Autowired
    PersonService personService;


    @PostMapping("/addPerson")
    public PersonDTOOutput addPersona(@RequestBody PersonDTOInput personaIn) throws Exception{
        return personService.addPersona(personaIn);
    }


    // para obtener persona by Name he declarado en el repositorio una funcion que SB hara el codigo por mi
    @GetMapping("/personByName")
    public List<PersonDTOOutput> getByName(String name)throws Exception{
        return personService.getByName(name);
    }
    @GetMapping("/all")
    public List<PersonDTOOutput> getAll()throws Exception{
        return personService.getPersonas();
    }
}
