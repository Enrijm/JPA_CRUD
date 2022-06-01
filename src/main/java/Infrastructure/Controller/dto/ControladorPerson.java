package Infrastructure.Controller.dto;

import Aplication.Port.CreatePersonPort;
import Aplication.Port.ReadPersonPort;
import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")

public class ControladorPerson {
    @Autowired
    CreatePersonPort createPersonPort;
    @Autowired
    ReadPersonPort readPersonPort;

    @PostMapping("/addPerson")  // Para comprobar validaciones en DTOinput
    public PersonDTOOutput addPersona(@Valid @RequestBody PersonDTOInput personaIn) throws Exception{
        return createPersonPort.addPersona(personaIn);
    }

    @GetMapping("/personByName")
    public List<PersonDTOOutput> getByName(String name)throws Exception{
        return readPersonPort.getByName(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTOOutput> getPersonaById(@PathVariable("id") Integer id) {
        try{
            return new ResponseEntity<>(readPersonPort.getPersonaById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public List<PersonDTOOutput> getAll()throws Exception{
        return readPersonPort.getPersonas();
    }
    // para ver como furula el ResponseEntity
    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }


}
