package mobile_recall.User;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDTO {
    private UUID identifier;
    private String username;
    private String password;
}
