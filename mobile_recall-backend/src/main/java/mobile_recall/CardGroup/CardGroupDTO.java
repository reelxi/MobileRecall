package mobile_recall.CardGroup;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CardGroupDTO {
    private UUID identifier;
    private String groupName;
    private UUID creatorId;
}
