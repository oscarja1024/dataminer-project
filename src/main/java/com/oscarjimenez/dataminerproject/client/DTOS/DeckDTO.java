package com.oscarjimenez.dataminerproject.client.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class DeckDTO {

    private String deckCode;
    private String version;
    private String format;
    private HeroDTO hero;
    private HeroDTO heroPower;
    @JsonProperty("class")
    private ClassDTO clase;
    private List<GetOneCardResponseDTO> cards;
    private int cardCount;



}
