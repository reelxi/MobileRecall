package mobile_recall.Cards;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "card")
public class CardController {

    private final CardService cardService;
    private final ModelMapper modelMapper;

    public CardController(CardService cardService, ModelMapper modelMapper) {
        this.cardService = cardService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> getAllCards() {
        List<CardDTO> entities = cardService.getAllCards()
                .stream()
                .map(this::convertToDto)
                .toList();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable UUID cardId) {
        Optional<Card> card = cardService.getCardById(cardId);
        if (card.isPresent()) {
            CardDTO entity = convertToDto(card.get());
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cardGroup={cardGroupId}")
    public ResponseEntity<List<CardDTO>> getCardsByCardGroupId(@PathVariable UUID cardGroupId) {
        List<CardDTO> entities = cardService.getCardsByCardGroupId(cardGroupId)
                .stream()
                .map(this::convertToDto)
                .toList();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardDTO> saveCard(@Valid @RequestBody CardDTO cardDTO) {
        Card card = cardService.saveCard(convertToEntity(cardDTO));
        return new ResponseEntity<>(convertToDto(card), HttpStatus.OK);
    }

    // MAPPER
    private CardDTO convertToDto(Card card) {
        return modelMapper.map(card, CardDTO.class);
    }

    private Card convertToEntity(CardDTO cardDTO) {
        return modelMapper.map(cardDTO, Card.class);
    }
}
