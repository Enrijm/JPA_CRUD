package Infrastructure.Dto.Input;



import lombok.Data;
import javax.validation.constraints.*;


@Data
// he tomado DTO Input como la informacion que recibo de front, de un usuario que quiere registrarse

public class PersonDTOInput {
    // Hacemos etiquetas de validacion ya que esta es la informacion que tenemos que comprobar
    @NotEmpty(message = "User cannot be empty")
    @Size(min = 6 , max = 10 , message = "It has to be minimun 6 and maximun 10 characters")
    private String usuario;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String surname;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotEmpty(message = "Company email cannot be empty")
    @Email(message = "Company email is not valid")
    private String company_email;
    @NotEmpty(message = "Personal email cannot be empty")
    @Email(message = "Personal email is not valid")
    private String personal_email;
    @NotEmpty(message = "City can not be empty")
    private String city;
    private String imagen_url;
}
