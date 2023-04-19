package com.oscarjimenez.dataminerproject.client.DTOS;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class MinionTypeDTO {

    private String slug;
    private String id;
    private String name;
    private List<String> gameModes;
}
