package Aplication.Port;

import Infrastructure.Dto.Input.PersonDTOInput;
import Infrastructure.Dto.Output.PersonDTOOutput;

public interface CreatePersonPort {
    PersonDTOOutput addPersona(PersonDTOInput personaIn) throws Exception;

}
