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

    public Optional<CardGroup> getCardGroupByID(UUID cardGroupId) {
        return cardGroupRepository.findById(cardGroupId);
    }

    public List<CardGroup> getCardGroupsByUserID(UUID userId) { return cardGroupRepository.findCardGroupByUserID(userId); }

    public CardGroup saveCardGroup(CardGroup cardGroup) {
        return cardGroupRepository.save(cardGroup);
    }
}
