package com.oscarjimenez.dataminerproject.client.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

@Data
@Jacksonized
@Builder
public class DeckDTO {

    private UUID deckCode;
    private String version;
    private String format;
    private HeroDTO hero;
    private HeroDTO heroPower;
    @JsonProperty("class")
    private ClassDTO clase;
    private List<GetOneCardResponseDTO> cards;
    private List<String> cardsIds;
    private int cardCount;



}
