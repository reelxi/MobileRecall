package mobile_recall.User;

import lombok.Data;

import java.util.UUID;

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class UserDTO {
    private UUID identifier;
    private String username;
    private String password;
}
