package com.oscarjimenez.dataminerproject.service.impl;

import com.oscarjimenez.dataminerproject.api.DTOS.MetadataRequest;
import com.oscarjimenez.dataminerproject.api.utils.CommonUtils;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.MetadataResponseDTO;
import com.oscarjimenez.dataminerproject.client.FeignBlizzardAPIGetMetadata;
import com.oscarjimenez.dataminerproject.service.GetMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetMetadataServiceImpl implements GetMetadataService {

    @Autowired
    FeignBlizzardAPIGetMetadata feignBlizzardAPIGetMetadata;

    @Autowired
    CommonUtils commonUtils;

    @Override
    public MetadataResponseDTO getAllMetadata(MetadataRequest requestMetadata) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetMetadata.getAllMetadata(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE);

        return response;
    }
}
