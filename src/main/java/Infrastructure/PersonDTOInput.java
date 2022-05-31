package Infrastructure;

import lombok.Data;
// DTO - DATA TRANSMISSION OBJECT - less arguments than Entity because we masked it, such as password , personal_email...
@Data


// he tomado DTO Input como la informacion que recibo de front, de un usuario que quiere registrarse

public class PersonDTOInput {
    private String usuario;
    private String name;
    private String surname;
    private String password;
    private String company_email;
    private String personal_email;
    private String city;
    private String imagen_url;
}
