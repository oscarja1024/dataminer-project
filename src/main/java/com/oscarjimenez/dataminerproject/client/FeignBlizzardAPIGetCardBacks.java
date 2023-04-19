package com.oscarjimenez.dataminerproject.client;

import com.oscarjimenez.dataminerproject.client.DTOS.CardBacksResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${values.rest.base-url}", name = "feignBlizzardAPIGetCardBacks")
public interface FeignBlizzardAPIGetCardBacks {

    @GetMapping("/cardbacks/{idorslug}")
    CardBacksResponseDTO getCardBacksById(@RequestHeader("Authorization") String token
            , @PathVariable String idorslug, @RequestParam String locale);

    @GetMapping("/cardbacks")
    CardBacksResponseDTO getCardBacksSort(@RequestHeader("Authorization") String token
            , @PathVariable String sort, @RequestParam String locale, @RequestParam String page);

    @GetMapping("/cardbacks")
    CardBacksResponseDTO getCardBacks(@RequestHeader("Authorization") String token,
             @RequestParam String locale, @RequestParam String page);

    @GetMapping("/cardbacks")
    CardBacksResponseDTO getCardBacksByCardBackCategory(@RequestHeader("Authorization") String token
            , @PathVariable String cardBackCategory, @RequestParam String locale, @RequestParam String page);

    @GetMapping("/cardbacks")
    CardBacksResponseDTO getCardBacksByCardBackCategorySort(@RequestHeader("Authorization") String token
            , @PathVariable String cardBackCategory, @RequestParam String locale, @PathVariable String sort, @RequestParam String page);

}
