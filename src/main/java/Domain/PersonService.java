package Domain;

import Infrastructure.PersonDTOInput;
import Infrastructure.PersonDTOOutput;
import java.util.List;


public interface PersonService{
// CRUD  --------- CREATE READ UPDATE DELEEEEEEEEEEEEEEETE
    //CREATE
    public PersonDTOOutput addPersona(PersonDTOInput personaIn) throws Exception;

    //READ
    PersonDTOOutput getPersonaById(Integer id) throws Exception;
    List<PersonDTOOutput> getPersonas();
    List<PersonDTOOutput> getByName(String name)throws Exception;

    //UPDATE
    PersonDTOOutput updatePersona(PersonDTOInput personaIn) throws Exception;

    //DELETE
    void deletePersona(Integer id) throws Exception;
}
