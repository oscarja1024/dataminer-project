package com.oscarjimenez.dataminerproject.api.controller;

import com.oscarjimenez.dataminerproject.api.DTOS.CardBackRequest;
import com.oscarjimenez.dataminerproject.api.DTOS.CardRequestDTO;
import com.oscarjimenez.dataminerproject.api.DTOS.ControllerDTO.MinerDTO;
import com.oscarjimenez.dataminerproject.api.DTOS.DeckRequestDTO;
import com.oscarjimenez.dataminerproject.api.DTOS.MetadataRequest;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.*;
import com.oscarjimenez.dataminerproject.service.GetCardsBacksService;
import com.oscarjimenez.dataminerproject.service.GetCardsService;
import com.oscarjimenez.dataminerproject.service.GetDecksService;
import com.oscarjimenez.dataminerproject.service.GetMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/hearthstoneMiner")
public class MinerController {

    @Autowired
    GetCardsBacksService getCardsBacksService;

    @Autowired
    GetCardsService getCardsService;

    @Autowired
    GetDecksService getDecksService;

    @Autowired
    GetMetadataService getMetadataService;

    @PostMapping(path="/metadata", produces = "application/json")
    public MetadataResponseDTO getMetadata(){
        return getMetadataService
                .getAllMetadata(MetadataRequest.builder().locale(Constants.LOCALE)
                        .build());
    }

    @PostMapping(path="/cardBacksById",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardsBackById(@RequestBody MinerDTO request){
        return getCardsBacksService
                .getCardBacksById(CardBackRequest.builder()
                        .idorSlug(request.getCardId())
                        .build());
    }

    @PostMapping(path="/cardBacksByCategory",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacksByCategory(@RequestBody MinerDTO request){
        return getCardsBacksService.getCardBacksByCardBackCategory(CardBackRequest.builder()
                .category(request.getParams().get(Constants.CATEGORY))
                .page(request.getPage()).build());
    }

    @PostMapping(path="/cardBacks",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacks(@RequestBody MinerDTO request){
        return getCardsBacksService.getCardBacks(CardBackRequest.builder()
                .page(request.getPage()).build());
    }

    @PostMapping(path="/cardBacksSort",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacksSort(@RequestBody MinerDTO request){
        return getCardsBacksService.getCardBacksSort(CardBackRequest.builder()
                .sort(request.getParams().get(Constants.SORT))
                .page(request.getPage()).build());
    }

    @PostMapping(path="/cardBacksByCategorySort",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacksCategorySort(@RequestBody MinerDTO request){
        return getCardsBacksService.getCardBacksByCardBackCategorySort(CardBackRequest.builder()
                .sort(request.getParams().get(Constants.SORT))
                .category(request.getParams().get(Constants.CATEGORY))
                .page(request.getPage()).build());
    }

    @PostMapping(path="/decksByCardsAndHero",consumes = "application/json" , produces = "application/json")
    public DeckDTO getDeckByCardListAndHero(@RequestBody MinerDTO request){
        return getDecksService.getDeckByCardListAndHero(DeckRequestDTO.builder()
                .ids(request.getCardIds())
                .hero(request.getParams().get(Constants.HERO))
                .build());
    }

    @PostMapping(path="/decksByCards",consumes = "application/json" , produces = "application/json")
    public DeckDTO getDeckByCardListAutoHero(@RequestBody MinerDTO request){
        return getDecksService.getDeckByCardListAutoHero(DeckRequestDTO.builder()
                .ids(request.getCardIds())
                .build());
    }

    @PostMapping(path="/decksByCode",consumes = "application/json" , produces = "application/json")
    public DeckDTO getDeckByCode(@RequestBody MinerDTO request){
        return getDecksService.getDeckByCode(DeckRequestDTO.builder()
                .code(request.getParams().get(Constants.CODE))
                .build());
    }

    @PostMapping(path="/oneCard", consumes = "application/json" , produces = "application/json")
    public GetOneCardResponseDTO getOneCardById(@RequestBody MinerDTO request){
        return getCardsService.getOneCardById(CardRequestDTO.builder()
                .cardId(request.getCardId()).build());
    }

    @PostMapping(path="/cards",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCards(@RequestBody MinerDTO request){
        return getCardsService.getAllCards(CardRequestDTO.builder()
                .page(request.getPage()).build());
    }

    @PostMapping(path="/cardsSort",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsSort(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsSort(CardRequestDTO.builder()
                .page(request.getPage())
                .sort(request.getParams().get(Constants.SORT)).build());
    }

    @PostMapping(path="/cardsPageSize",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsSetPageSize(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsSetPageSize(CardRequestDTO.builder()
                .page(request.getPage())
                .pageSize(request.getParams().get(Constants.PAGE_SIZE)).build());
    }

    @PostMapping(path="/cardsPageSizeSort",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByPageSetPageSizeSort(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByPageSetPageSizeSort(CardRequestDTO.builder()
                .page(request.getPage())
                .pageSize(request.getParams().get(Constants.PAGE_SIZE))
                .sort(request.getParams().get(Constants.SORT)).build());
    }

    @PostMapping(path="/cardsByManaCost",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByManaCost(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByManaCost(CardRequestDTO.builder()
                .page(request.getPage())
                .mana(request.getParams().get(Constants.MANA)).build());
    }

    @PostMapping(path="/cardsByManaCostAndAttack",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByManaCostAndAttack(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByManaCostAndAttack(CardRequestDTO.builder()
                .page(request.getPage())
                .mana(request.getParams().get(Constants.MANA))
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @PostMapping(path="/cardsByAttack",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByAttack(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByAttack(CardRequestDTO.builder()
                .page(request.getPage())
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @PostMapping(path="/cardsByType",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByType(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByType(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE)).build());
    }

    @PostMapping(path="/cardsByAttackAndType",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByTypeAndAttack(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByTypeAndAttack(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE))
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @PostMapping(path="/cardsByAttackAndManaCost",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByTypeAndManaCost(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByTypeAndManaCost(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE))
                .mana(request.getParams().get(Constants.MANA)).build());
    }

    @PostMapping(path="/cardsByAttackAndManaCostAndType",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByTypeAndAttackAndManaCost(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByTypeAndAttackAndManaCost(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE))
                .mana(request.getParams().get(Constants.MANA))
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @PostMapping(path="/cardsByHealth",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByHealth(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByHealth(CardRequestDTO.builder()
                .page(request.getPage())
                .health(request.getParams().get(Constants.HEALTH)).build());
    }

    @PostMapping(path="/cardsByGameMode",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByGameMode(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsByGameMode(CardRequestDTO.builder()
                .page(request.getPage())
                .gameMode(request.getParams().get(Constants.GAME_MODE)).build());
    }

    @PostMapping(path="/cardsBySpellSchool",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsBySpellSchool(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsBySpellSchool(CardRequestDTO.builder()
                .page(request.getPage())
                .spellSchool(request.getParams().get(Constants.SPELL_SCHOOL)).build());
    }

    @PostMapping(path="/cardsBySet",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsBySet(@RequestBody MinerDTO request){
        return getCardsService.getAllCardsBySet(CardRequestDTO.builder()
                .page(request.getPage())
                .set(request.getParams().get(Constants.SET)).build());
    }

}
