package com.oscarjimenez.dataminerproject.api.DTOS;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class CardRequestDTO {

    private String cardId;
    private String locale;
    private String page;
    private String sort;
    private String pageSize;
    private String mana;
    private String attack;
    private String health;
    private String type;
    private String gameMode;
    private String spellSchool;
    private String set;


}
