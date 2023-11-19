package mobile_recall.Cards;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{cardId}")
    public Card getCardByID(@PathVariable UUID cardId) {
        Optional<Card> card = cardService.getCardByID(cardId);
        if (card.isPresent()) {
            return card.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Element of " + getClass() + " with ID: " + cardId);
    }

    @GetMapping("/cardGroup={cardGroupId}")
    public List<Card> getCardsByCardGroupID(@PathVariable UUID cardGroupId) {
        return cardService.getCardsByCardGroupID(cardGroupId);
    }

    @PostMapping
    public Card saveCard(@Valid @RequestBody Card card) {
        return cardService.saveCard(card);
    }
}
