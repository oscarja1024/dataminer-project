package com.oscarjimenez.dataminerproject.client;

import com.oscarjimenez.dataminerproject.client.DTOS.GetCardsResponseDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.GetOneCardResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "${values.rest.base-url}", name = "feignBlizzardAPIGetCards")
public interface FeignBlizzardAPIGetCards {

    @GetMapping("/cards/{idorslug}")
    GetOneCardResponseDTO getOneCardById(@RequestHeader("Authorization") String token
            , @PathVariable String idorslug, @RequestParam String locale);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCards(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsSort(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String sort);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsSetPageSize(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String pageSize);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByPageSetPageSizeSort(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String pageSize, @RequestParam String sort);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByManaCost(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page,@RequestParam int manaCost);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByManaCostAndAttack(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page,@RequestParam String manaCost, @RequestParam String attack);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByAttack(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String attack);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByType(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String type);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByTypeAndAttack(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String type, @RequestParam String attack);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByTypeAndManaCost(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String type, @RequestParam String manaCost);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByTypeAndAttackAndManaCost(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String type, @RequestParam String attack, @RequestParam String manaCost);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByHealth(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String health);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsByGameMode(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String gameMode);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsBySpellSchool(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String spellSchool);

    @GetMapping("/cards")
    GetCardsResponseDTO getAllCardsBySet(@RequestHeader("Authorization") String token
            , @RequestParam String locale, @RequestParam String page, @RequestParam String set);



}
