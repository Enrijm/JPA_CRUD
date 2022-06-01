package Aplication;


import Aplication.Port.CreatePersonPort;
import Domain.PersonEntity;
import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;
import Infrastructure.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCase implements CreatePersonPort {
    @Autowired
    PersonRepository personRepository;
    @Override
    public PersonDTOOutput addPersona(PersonDTOInput personaIn) throws Exception{
        PersonEntity persona = new PersonEntity(personaIn);
        personRepository.save(persona);
        return new PersonDTOOutput(persona);
    }
}
