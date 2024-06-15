package ec.artec.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private String status;
    private int code;
    private T data;
    private String message;

    // Constructor para respuesta con datos
    public ApiResponse(String status, int code, T data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }

    // Constructor para respuesta con mensaje
    public ApiResponse(String status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
