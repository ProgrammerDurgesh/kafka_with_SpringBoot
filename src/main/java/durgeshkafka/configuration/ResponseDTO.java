package durgeshkafka.configuration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import durgeshkafka.dto.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseDTO extends ApiMessage {

    public ResponseDTO(HttpStatus status, String error, String message) {
        super(status, error, message);
    }

    public ResponseDTO(HttpStatus status, String error, String message, Integer code, Object data) {
        super(status, error, message, code, data);
    }

    public ResponseDTO(HttpStatus status, String message, Object data) {
        super(status, message, data);
    }

    public ResponseDTO(HttpStatus status, String message) {
        super(status, message);
    }

    @JsonCreator
    public ResponseDTO(@JsonProperty("status") HttpStatus status, @JsonProperty("message") String message, @JsonProperty("code") Integer code, @JsonProperty("data") Object data) {
        super(status, message, code, data);
    }

}
