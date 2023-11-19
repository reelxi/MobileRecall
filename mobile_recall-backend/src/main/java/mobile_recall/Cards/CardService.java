package mobile_recall.Cards;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardByID(UUID cardId) {
        return cardRepository.findById(cardId);
    }

    public List<Card> getCardsByCardGroupID(UUID cardGroupId) {
        return cardRepository.findCardsByCardGroupID(cardGroupId);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }
}
