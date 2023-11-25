package mobile_recall.CardGroup;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "cardGroup")
public class CardGroupController {

    private final CardGroupService cardGroupService;
    private final ModelMapper modelMapper;

    public CardGroupController(CardGroupService cardGroupService, ModelMapper modelMapper) {
        this.cardGroupService = cardGroupService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<CardGroupDTO>> getAllCardGroups() {
        List<CardGroupDTO> entities = cardGroupService.getAllCardGroups()
                .stream()
                .map(this::convertToDto)
                .toList();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/{cardGroupId}")
    public ResponseEntity<CardGroupDTO> getCardGroupById(@PathVariable UUID cardGroupId) {
        Optional<CardGroup> cardGroup = cardGroupService.getCardGroupById(cardGroupId);
        if (cardGroup.isPresent()) {
            CardGroupDTO entity = convertToDto(cardGroup.get());
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user={userId}")
    public ResponseEntity<List<CardGroupDTO>> getCardGroupsByUserId(@PathVariable UUID userId) {
        List<CardGroupDTO> entities = cardGroupService.getCardGroupsByUserId(userId)
                .stream()
                .map(this::convertToDto)
                .toList();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardGroupDTO> saveCard(@Valid @RequestBody CardGroupDTO cardGroupDTO) {
        CardGroup entity = cardGroupService.saveCardGroup(convertToEntity(cardGroupDTO));
        return new ResponseEntity<>(convertToDto(entity), HttpStatus.OK);
    }

    // MAPPER
    private CardGroupDTO convertToDto(CardGroup cardGroup) {
        return modelMapper.map(cardGroup, CardGroupDTO.class);
    }

    private CardGroup convertToEntity(CardGroupDTO cardGroupDTO) {
        return modelMapper.map(cardGroupDTO, CardGroup.class);
    }
}
