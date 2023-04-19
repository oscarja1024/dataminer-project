package com.oscarjimenez.dataminerproject.api.DTOS.ControllerDTO;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Data
@Jacksonized
@Builder
public class MinerDTO {

    @NonNull
    private String cardId;
    private List<String> cardIds;
    @NonNull
    private String page;

    private Map<String,String> params;


}
