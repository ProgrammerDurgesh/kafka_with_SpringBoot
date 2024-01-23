package durgeshkafka.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the errors that are sent to the REST clients.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiMessage {

    private HttpStatus status;
    private String message;
    private Integer code;
    private String error;
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectError> objectErrors = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FieldError> fieldErrors = new ArrayList<>();

    public ApiMessage(HttpStatus status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public ApiMessage(HttpStatus status, String error, String message, Integer code, Object data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public ApiMessage(HttpStatus status, String message, Object data) {
        this.status = status;
        this.code = status.value();
        this.message = message;
        this.data = data;
    }

    public ApiMessage(HttpStatus status, String message) {
        this.status = status;
        this.code = status.value();
        this.message = message;
    }

    public ApiMessage(@JsonProperty("status") HttpStatus status, @JsonProperty("message") String message, @JsonProperty("code") Integer code, @JsonProperty("data") Object data) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
