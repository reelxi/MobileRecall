package mobile_recall.CardGroup;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mobile_recall.User.User;

import java.util.UUID;

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Entity
public class CardGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;
    @NotNull
    private String groupName;
    @ManyToOne
    private User creator;
}
