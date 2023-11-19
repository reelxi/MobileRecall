package mobile_recall.Cards;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import mobile_recall.CardGroup.CardGroup;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Main entity to represent "index"-cards
 *
 * @author René Elbracht
 */
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;
    @NotNull
    private String question;
    @NotNull
    private String expectedAnswer;

    // Meta-data for card-entity
    @NotNull
    private LocalDate creationDate;
    private float successRate;

    // Entity-Relations
    @ManyToOne
    private CardGroup cardGroup;

    public Card() {
    }

    /**
     * Simplest form of a card
     */
    public Card(@NotNull String question, @NotNull String expectedAnswer) {
        this.question = question;
        this.expectedAnswer = expectedAnswer;
        this.creationDate = LocalDate.now();
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public @NotNull String getQuestion() {
        return question;
    }

    public @NotNull String getExpectedAnswer() {
        return expectedAnswer;
    }

    public @NotNull LocalDate getCreationDate() {
        return creationDate;
    }

    public float getSuccessRate() {
        return successRate;
    }

    public CardGroup getCardGroup() {
        return cardGroup;
    }

    public void setQuestion(@NotNull String question) {
        this.question = question;
    }

    public void setExpectedAnswer(@NotNull String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public void setSuccessRate(float successRate) {
        this.successRate = successRate;
    }

    public void setCardGroup(CardGroup cardGroup) {
        this.cardGroup = cardGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (Float.compare(card.getSuccessRate(), getSuccessRate()) != 0) return false;
        if (!getIdentifier().equals(card.getIdentifier())) return false;
        if (!getQuestion().equals(card.getQuestion())) return false;
        if (!getExpectedAnswer().equals(card.getExpectedAnswer())) return false;
        if (!getCreationDate().equals(card.getCreationDate())) return false;
        return getCardGroup().equals(card.getCardGroup());
    }

    @Override
    public int hashCode() {
        int result = getIdentifier().hashCode();
        result = 31 * result + getQuestion().hashCode();
        result = 31 * result + getExpectedAnswer().hashCode();
        result = 31 * result + getCreationDate().hashCode();
        result = 31 * result + getCardGroup().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "identifier=" + identifier +
                ", question='" + question + '\'' +
                ", expectedAnswer='" + expectedAnswer + '\'' +
                ", creationDate=" + creationDate +
                ", successRate=" + successRate +
                ", cardGroup=" + cardGroup +
                '}';
    }
}
