package Aplication.Port;

import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;

public interface UpdatePersonPort {
    PersonDTOOutput updatePersona(Integer id, PersonDTOInput personaIn) throws Exception;
}
