package mobile_recall.CardGroup;

import jakarta.validation.Valid;
import mobile_recall.User.User;
import mobile_recall.User.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "cardGroup")
public class CardGroupController {

    private final CardGroupService cardGroupService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;

    public CardGroupController(CardGroupService cardGroupService, ModelMapper modelMapper, UserRepository userRepository, Logger logger) {
        this.cardGroupService = cardGroupService;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.logger = logger;
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
    public ResponseEntity<CardGroupDTO> createCardGroup(@Valid @RequestBody CardGroupDTO cardGroupDTO) {
        if (cardGroupDTO.getIdentifier() != null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN); //Post DTO with ID could lead to errors and is forbidden
        }
        CardGroup entity = cardGroupService.saveCardGroup(convertToEntity(cardGroupDTO));
        logger.info("{} created! NAME: {}, CREATOR: {}", entity.getClass(), entity.getGroupName(), entity.getCreator().getUsername());
        return new ResponseEntity<>(convertToDto(entity), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CardGroupDTO> putCardGroup(@Valid @RequestBody CardGroupDTO newCardGroupDTO) {
        if (newCardGroupDTO.getIdentifier() == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN); //Put DTO without ID could lead to errors and is forbidden
        }
        CardGroup cardGroup = convertToEntity(newCardGroupDTO);
        CardGroup cardGroupUpdated = cardGroupService.saveCardGroup(cardGroup);
        return new ResponseEntity<>(convertToDto(cardGroupUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardGroupDTO> deleteCardGroup(@PathVariable UUID id) {
        Optional<CardGroup> cardGroup = cardGroupService.getCardGroupById(id);
        if (cardGroup.isPresent()) {
            cardGroupService.deleteById(id);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN); //No such Element for ID: id
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // MAPPER
    private CardGroupDTO convertToDto(CardGroup cardGroup) {
        CardGroupDTO dto = modelMapper.map(cardGroup, CardGroupDTO.class);
        dto.setCreatorId(cardGroup.getCreator().getIdentifier());
        return dto;
    }

    private CardGroup convertToEntity(CardGroupDTO cardGroupDTO) {
        CardGroup entity = modelMapper.map(cardGroupDTO, CardGroup.class);
        Optional<User> creator = userRepository.findById(cardGroupDTO.getCreatorId());
        if (creator.isPresent()) {
            entity.setCreator(creator.get());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "missing Creator");
        }
        return entity;
    }
}
