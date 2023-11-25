package mobile_recall.Cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    @Query(value = "SELECT c FROM Card c WHERE c.cardGroup.identifier = ?1")
    List<Card> findCardsByCardGroupId(UUID identifier);
}
