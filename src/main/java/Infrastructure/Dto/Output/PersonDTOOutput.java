package Infrastructure.Dto.Output;

import Domain.PersonEntity;
import lombok.Data;


import java.util.Date;
@Data

// He tomado DTO output como informacion tratada que queremos enviar a FRONT

public class PersonDTOOutput {
    private Integer id_persona;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    // constructor
    public PersonDTOOutput(PersonEntity persona){
        setId_persona(persona.getId_person());
        setUsuario(persona.getUsuario());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImage_url(persona.getImage_url());
        setTermination_date(persona.getTermination_date());
    }
}