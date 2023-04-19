package com.oscarjimenez.dataminerproject.client.DTOS;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class GetCardsResponseDTO {

    private List<GetOneCardResponseDTO> cards;
    private int cardCount;
    private int pageCount;
    private int page;

}
