package Domain;

import Infrastructure.PersonDTOInput;
import Infrastructure.PersonDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    PersonRepository personRepository;

    //CREATE
    @Override
    public PersonDTOOutput addPersona(PersonDTOInput personaIn) throws Exception{
        PersonEntity persona = new PersonEntity(personaIn);
        personRepository.save(persona);
        return new PersonDTOOutput(persona);
    }

    //READ
    @Override
    public PersonDTOOutput getPersonaById(Integer id) throws Exception{
        PersonEntity persona = personRepository.findById(id).orElseThrow(() -> new Exception ("Persona no encontrada para id: " + id));
        return new PersonDTOOutput(persona);
    }
    @Override
    public List<PersonDTOOutput> getPersonas(){
        List<PersonDTOOutput> personDTOOutputList = new ArrayList<>();
        personRepository.findAll().forEach(p ->{
            PersonDTOOutput personDTOOutput = new PersonDTOOutput(p);
            personDTOOutputList.add(personDTOOutput);
        });
        return personDTOOutputList;
    }

    @Override
    public List<PersonDTOOutput> getByName(String name){
        List<PersonDTOOutput> listaSalida = new ArrayList<>();
        personRepository.findByName(name).forEach(pE->{
            listaSalida.add(new PersonDTOOutput(pE));
        });
        return listaSalida;
    }


    //UPDATE
    @Override
    public PersonDTOOutput updatePersona(PersonDTOInput personaIn) throws Exception{
        return null;
    }

    //DELETE
    @Override
    public void deletePersona(Integer id) throws Exception{
        personRepository.deleteById(id);
    }

}
