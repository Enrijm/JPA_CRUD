package Infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@AllArgsConstructor
@Getter
// Clase con la que tendremos los atributos de nuestro error
public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String message;
    private String details;
}
