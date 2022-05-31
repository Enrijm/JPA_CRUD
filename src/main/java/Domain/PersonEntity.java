package Domain;

import Infrastructure.PersonDTOInput;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Personas")
public class PersonEntity {
    @Id @GeneratedValue
    private Integer id_person;
    @Column@NotNull
    private String usuario; // tengo que hacerlo NO NULL MAX-Length 10 - min:6
    @Column@NotNull
    private String password; // NOT NULL
    @Column@NotNull
    private String name; // NOT NULL
    @Column
    private String surname;
    @Column@NotNull
    private String company_email; // NOT NULL
    @Column@NotNull
    private String personal_email;// NOT NULL
    @Column@NotNull
    private String city;// NOT NULL
    @Column@NotNull
    private Boolean active;// NOT NULL
    @Column@NotNull
    private Date created_date;// NOT NULL
    @Column@NotNull
    private String image_url;
    @Column@NotNull
    private Date termination_date;

    public PersonEntity(PersonDTOInput personaIn) throws Exception{
        if(personaIn.getUsuario() != null
                && personaIn.getUsuario().length() <= 10
                && personaIn.getUsuario().length() >= 6
        ){
            setUsuario(personaIn.getUsuario());
        }else{
            throw new Exception("El campo usuario debe tener entre 6 y 10 caracteres");
        }
        if(personaIn.getName() == null){
            throw new Exception("El campo nombre no puede estar vacío");
        }else{
            setName(personaIn.getName());
        }
        if(personaIn.getPassword() == null){
            throw new Exception("El campo contraseña no puede estar vacío");
        }else{
            setPassword(personaIn.getPassword());
        }
        if(personaIn.getCompany_email() == null){
            throw new Exception("El campo email de compañia no puede estar vacío");
        }else{
            setCompany_email(personaIn.getCompany_email());
        }
        if(personaIn.getPersonal_email() == null){
            throw new Exception("El campo email personal no puede estar vacío");
        }else{
            setPersonal_email(personaIn.getPersonal_email());
        }
        if(personaIn.getCity() == null){
            throw new Exception("El campo ciudad no puede estar vacío");
        }else{
            setCity(personaIn.getCity());
        }
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
