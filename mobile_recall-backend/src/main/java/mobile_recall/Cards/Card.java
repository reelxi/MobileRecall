package mobile_recall.Cards;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mobile_recall.CardGroup.CardGroup;

import java.time.LocalDate;
import java.util.UUID;

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;
    @NotNull
    private String question;
    @NotNull
    private String expectedAnswer;
    @NotNull
    private LocalDate creationDate;
    private float successRate;
    @ManyToOne
    private CardGroup cardGroup;
}
