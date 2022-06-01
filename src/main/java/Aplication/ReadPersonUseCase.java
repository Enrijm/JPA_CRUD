package Aplication;

import Aplication.Port.ReadPersonPort;
import Domain.PersonEntity;
import Infrastructure.Dto.Output.PersonDTOOutput;
import Infrastructure.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ReadPersonUseCase implements ReadPersonPort {

    @Autowired
    PersonRepository personRepository;

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
}
