package mobile_recall.CardGroup;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import mobile_recall.User.User;

import java.util.UUID;

@Entity
public class CardGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID identifier;

    @NotNull
    private String groupName;

    // Entity-Relations
    @ManyToOne
    private User creator;

    public CardGroup() {
    }

    public CardGroup(@NotNull String groupName, @NotNull User creator) {
        this.groupName = groupName;
        this.creator = creator;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public @NotNull String getGroupName() {
        return groupName;
    }

    public void setGroupName(@NotNull String groupName) {
        this.groupName = groupName;
    }

    public User getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardGroup cardGroup = (CardGroup) o;

        if (!getIdentifier().equals(cardGroup.getIdentifier())) return false;
        if (!getGroupName().equals(cardGroup.getGroupName())) return false;
        return getCreator() != null ? getCreator().equals(cardGroup.getCreator()) : cardGroup.getCreator() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdentifier().hashCode();
        result = 31 * result + getGroupName().hashCode();
        result = 31 * result + (getCreator() != null ? getCreator().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CardGroup{" +
                "identifier=" + identifier +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                '}';
    }
}
