package durgeshkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationDto {
    public final Integer ID = 111;
    public final String message = "you got new notification message";
    public final String url = "https://mattermost.drcsystems.com/tech/channels/truflux-development";

}
