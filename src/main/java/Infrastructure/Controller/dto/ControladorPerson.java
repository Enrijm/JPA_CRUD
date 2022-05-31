package Infrastructure.Controller.dto;


import Aplication.PersonService;
import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/personByName")
    public List<PersonDTOOutput> getByName(String name)throws Exception{
        return personService.getByName(name);
    }
    @GetMapping("/all")
    public List<PersonDTOOutput> getAll()throws Exception{
        return personService.getPersonas();
    }
}
