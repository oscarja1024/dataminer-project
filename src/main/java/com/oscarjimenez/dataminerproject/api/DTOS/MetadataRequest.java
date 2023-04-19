package com.oscarjimenez.dataminerproject.api.DTOS;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class MetadataRequest {

    private String locale;
}
