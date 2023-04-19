package com.oscarjimenez.dataminerproject.client;

import com.oscarjimenez.dataminerproject.client.DTOS.GetOneCardResponseDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.MetadataResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${values.rest.base-url}", name = "feignBlizzardAPIGetMetada")
public interface FeignBlizzardAPIGetMetadata {

    @GetMapping("/metadata")
    MetadataResponseDTO getAllMetadata(@RequestHeader("Authorization") String token
            ,@RequestParam String locale);

}
