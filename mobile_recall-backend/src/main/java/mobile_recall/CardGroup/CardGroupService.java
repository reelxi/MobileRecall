package mobile_recall.CardGroup;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardGroupService {

    private final CardGroupRepository cardGroupRepository;

    public CardGroupService(CardGroupRepository cardGroupRepository) {
        this.cardGroupRepository = cardGroupRepository;
    }

    public List<CardGroup> getAllCardGroups() {
        return cardGroupRepository.findAll();
    }

    public Optional<CardGroup> getCardGroupById(UUID cardGroupId) {
        return cardGroupRepository.findById(cardGroupId);
    }

    public List<CardGroup> getCardGroupsByUserId(UUID userId) {
        return cardGroupRepository.findCardGroupByUserId(userId);
    }

    public CardGroup saveCardGroup(CardGroup cardGroup) {
        return cardGroupRepository.save(cardGroup);
    }
}
