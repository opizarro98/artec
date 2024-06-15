package ec.artec.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String status;
    private int code;
    private String message;

    public ErrorResponse(String status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
