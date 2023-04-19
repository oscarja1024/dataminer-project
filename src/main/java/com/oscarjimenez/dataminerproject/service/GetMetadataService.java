package com.oscarjimenez.dataminerproject.service;

import com.oscarjimenez.dataminerproject.api.DTOS.MetadataRequest;
import com.oscarjimenez.dataminerproject.client.DTOS.MetadataResponseDTO;

public interface GetMetadataService {

    MetadataResponseDTO getAllMetadata(MetadataRequest requestMetadata);

}
