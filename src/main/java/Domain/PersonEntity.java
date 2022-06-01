package Domain;

import Infrastructure.Dto.Input.PersonDTOInput;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Personas")
public class PersonEntity {
    // Las etiquetas de not null o maximo y minimo lo haremos directamente en DTOinput que recibiremos
    @Id @GeneratedValue
    private Integer id_person;
    @Column
    private String usuario; // tengo que hacerlo NO NULL MAX-Length 10 - min:6
    @Column
    private String password; // NOT NULL
    @Column
    private String name; // NOT NULL
    @Column
    private String surname;
    @Column
    private String company_email; // NOT NULL
    @Column
    private String personal_email;// NOT NULL
    @Column
    private String city;// NOT NULL
    @Column
    private Boolean active;// NOT NULL
    @Column
    private Date created_date;// NOT NULL
    @Column
    private String image_url;
    @Column
    private Date termination_date;

    public PersonEntity(PersonDTOInput personaIn) throws Exception{
        //Validaciones en en PersonaInputDTO
        setUsuario(personaIn.getUsuario());
        setName(personaIn.getName());
        setPassword(personaIn.getPassword());
        setCompany_email(personaIn.getCompany_email());
        setPersonal_email(personaIn.getPersonal_email());
        setCity(personaIn.getCity());
        setCreated_date(new Date());
        setActive(true);
        setImage_url(personaIn.getImagen_url());
        setSurname(personaIn.getSurname());
    }

    public void update(PersonDTOInput personaIn)throws Exception{
        if(personaIn.getUsuario() != null
                && personaIn.getUsuario().length() <= 10
                && personaIn.getUsuario().length() >= 6
        ){
            setUsuario(personaIn.getUsuario());
        }
        if(personaIn.getName() != null){
            setName(personaIn.getName());
        }
        if(personaIn.getPassword() != null){
            setPassword(personaIn.getPassword());
        }
        if(personaIn.getCompany_email() != null){
            setCompany_email(personaIn.getCompany_email());
        }
        if(personaIn.getPersonal_email() != null){
            setPersonal_email(personaIn.getPersonal_email());
        }
        if(personaIn.getCity() != null){
            setCity(personaIn.getCity());
        }
        if(personaIn.getSurname() != null){
            setSurname(personaIn.getSurname());
        }
        if(personaIn.getImagen_url() != null){
            setImage_url(personaIn.getImagen_url());
        }
    }
}
