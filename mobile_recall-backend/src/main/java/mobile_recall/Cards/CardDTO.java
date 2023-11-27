package mobile_recall.Cards;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class CardDTO {
    private UUID identifier;
    private String question;
    private String expectedAnswer;
    private LocalDate creationDate;
    private float successRate;
    private UUID cardGroupId;
}
