package Aplication;

import Aplication.Port.UpdatePersonPort;
import Domain.PersonEntity;
import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;
import Infrastructure.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonUseCase implements UpdatePersonPort {
    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonDTOOutput updatePersona(Integer id, PersonDTOInput personaIn) throws Exception{
        PersonEntity personToUpdate = personRepository.findById(id).orElseThrow(()-> new Exception("Persona no encontrada para actualizar" + id));
        personToUpdate.update(personaIn);
        personRepository.save(personToUpdate);
        return new PersonDTOOutput(personToUpdate);
    }
}
