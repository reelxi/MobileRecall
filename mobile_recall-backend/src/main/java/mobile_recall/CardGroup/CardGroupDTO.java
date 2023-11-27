package mobile_recall.CardGroup;

import lombok.Data;

import java.util.UUID;

@Data //@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class CardGroupDTO {
    private UUID identifier;
    private String groupName;
    private UUID creatorId;
}
