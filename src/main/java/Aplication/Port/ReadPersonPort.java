package Aplication.Port;

import Infrastructure.Dto.Output.PersonDTOOutput;
import java.util.List;

public interface ReadPersonPort {
    PersonDTOOutput getPersonaById(Integer id) throws Exception;
    List<PersonDTOOutput> getPersonas();
    List<PersonDTOOutput> getByName(String name)throws Exception;
}
