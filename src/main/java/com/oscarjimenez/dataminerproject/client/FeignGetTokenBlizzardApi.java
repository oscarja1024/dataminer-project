package com.oscarjimenez.dataminerproject.client;

import com.oscarjimenez.dataminerproject.client.DTOS.BearerTokenResponseDTO;

import feign.Body;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url="${values.rest.token-url}", name="feignGetTokenBlizzardApi")
public interface FeignGetTokenBlizzardApi {

    @PostMapping()
    @Headers("Content-Type: application/x-www-form-urlencoded")
    BearerTokenResponseDTO getAccessToken(@RequestHeader("Authorization") String auth, @RequestBody MultiValueMap<String, String> body);

}
