package mobile_recall.Cards;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class CardDTO {
    private UUID identifier;
    private String question;
    private String expectedAnswer;
    private LocalDate creationDate;
    private float successRate;
    private UUID cardGroupId;
}
