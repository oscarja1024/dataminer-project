package com.oscarjimenez.dataminerproject.api.utils;

import com.oscarjimenez.dataminerproject.client.DTOS.BearerTokenResponseDTO;
import com.oscarjimenez.dataminerproject.client.FeignGetTokenBlizzardApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class CommonUtils {

    @Autowired
    FeignGetTokenBlizzardApi feignGetTokenBlizzardApi;

    @Value("${values.rest.basic-auth}")
    String basicAuth;

    public BearerTokenResponseDTO getToken(){

        MultiValueMap<String, String> formParams = new LinkedMultiValueMap<>();
        formParams.add("grant_type", "client_credentials");

        var token = feignGetTokenBlizzardApi.getAccessToken(basicAuth, formParams);

        return token;
    }

}
