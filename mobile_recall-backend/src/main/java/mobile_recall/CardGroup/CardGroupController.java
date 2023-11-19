package mobile_recall.CardGroup;

import jakarta.validation.Valid;
import mobile_recall.Cards.Card;
import mobile_recall.Cards.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "cardGroup")
public class CardGroupController {

    private final CardGroupService cardGroupService;

    public CardGroupController(CardGroupService cardGroupService) {
        this.cardGroupService = cardGroupService;
    }

    @GetMapping
    public List<CardGroup> getAllCardGroups() {
        return cardGroupService.getAllCardGroups();
    }

    @GetMapping("/{cardGroupId}")
    public CardGroup getCardGroupByID(@PathVariable UUID cardGroupId) {
        Optional<CardGroup> cardGroup = cardGroupService.getCardGroupByID(cardGroupId);
        if (cardGroup.isPresent()) {
            return cardGroup.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Element of " + getClass() + " with ID: " + cardGroupId);
    }

    @GetMapping("/user={userId}")
    public List<CardGroup> getCardGroupsByUserID(@PathVariable UUID userId) {
        return cardGroupService.getCardGroupsByUserID(userId);
    }

    @PostMapping
    public CardGroup saveCard(@Valid @RequestBody CardGroup cardGroup) {
        return cardGroupService.saveCardGroup(cardGroup);
    }

}
