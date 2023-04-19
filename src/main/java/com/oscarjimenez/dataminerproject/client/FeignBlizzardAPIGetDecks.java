package com.oscarjimenez.dataminerproject.client;

import com.oscarjimenez.dataminerproject.client.DTOS.DeckDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${values.rest.base-url}", name = "feignBlizzardAPIGetDecks")
public interface FeignBlizzardAPIGetDecks {

    @GetMapping("/deck")
    DeckDTO getDeckByCardListAndHero(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam List<String> ids, @RequestParam String hero);

    @GetMapping("/deck")
    DeckDTO getDeckByCardListAutoHero(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam List<String> ids);

    //Get Deck by one preDone
    @GetMapping("/deck")
    DeckDTO getDeckByCode(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String code);
}
