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

    public Optional<Card> getCardById(UUID cardId) {
        return cardRepository.findById(cardId);
    }

    public List<Card> getCardsByCardGroupId(UUID cardGroupId) {
        return cardRepository.findCardsByCardGroupId(cardGroupId);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }
}
