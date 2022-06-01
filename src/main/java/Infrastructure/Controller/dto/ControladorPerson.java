package Infrastructure.Controller.dto;

import Aplication.Port.CreatePersonPort;
import Aplication.Port.ReadPersonPort;
import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persona")

public class ControladorPerson {
    @Autowired
    CreatePersonPort createPersonPort;
    @Autowired
    ReadPersonPort readPersonPort;

    @PostMapping("/addPerson")
    public PersonDTOOutput addPersona(@RequestBody PersonDTOInput personaIn) throws Exception{
        return createPersonPort.addPersona(personaIn);
    }

    @GetMapping("/personByName")
    public List<PersonDTOOutput> getByName(String name)throws Exception{
        return readPersonPort.getByName(name);
    }
    @GetMapping("/all")
    public List<PersonDTOOutput> getAll()throws Exception{
        return readPersonPort.getPersonas();
    }
}
