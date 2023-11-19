package mobile_recall.CardGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardGroupRepository extends JpaRepository<CardGroup, UUID> {
    @Query(value = "SELECT cg FROM CardGroup cg WHERE cg.creator.identifier = ?1")
    List<CardGroup> findCardGroupByUserID(UUID identifier);
}
