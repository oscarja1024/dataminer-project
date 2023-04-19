package com.oscarjimenez.dataminerproject.api.DTOS;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class DeckRequestDTO {

    private List<String> ids;
    private String hero;
    private String code;

}
