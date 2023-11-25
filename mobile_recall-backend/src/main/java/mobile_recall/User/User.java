package mobile_recall.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;
}
