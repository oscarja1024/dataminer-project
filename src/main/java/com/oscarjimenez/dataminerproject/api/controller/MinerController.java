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

    @GetMapping(path="/metadata", produces = "application/json")
    public MetadataResponseDTO getMetadata(){
        return getMetadataService
                .getAllMetadata(MetadataRequest.builder().locale(Constants.LOCALE)
                        .build());
    }

    @GetMapping(path="/cardBacksById",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardsBackById(MinerDTO request){
        return getCardsBacksService
                .getCardBacksById(CardBackRequest.builder()
                        .idorSlug(request.getCardId())
                        .build());
    }

    @GetMapping(path="/cardBacksByCategory",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacksByCategory(MinerDTO request){
        return getCardsBacksService.getCardBacksByCardBackCategory(CardBackRequest.builder()
                .category(request.getParams().get(Constants.CATEGORY))
                .page(request.getPage()).build());
    }

    @GetMapping(path="/cardBacks",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacks(MinerDTO request){
        return getCardsBacksService.getCardBacks(CardBackRequest.builder()
                .page(request.getPage()).build());
    }

    @GetMapping(path="/cardBacksSort",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacksSort(MinerDTO request){
        return getCardsBacksService.getCardBacksSort(CardBackRequest.builder()
                .sort(request.getParams().get(Constants.SORT))
                .page(request.getPage()).build());
    }

    @GetMapping(path="/cardBacksByCategorySort",consumes = "application/json" , produces = "application/json")
    public CardBacksResponseDTO getCardBacksCategorySort(MinerDTO request){
        return getCardsBacksService.getCardBacksByCardBackCategorySort(CardBackRequest.builder()
                .sort(request.getParams().get(Constants.SORT))
                .category(request.getParams().get(Constants.CATEGORY))
                .page(request.getPage()).build());
    }

    @GetMapping(path="/decksByCardsAndHero",consumes = "application/json" , produces = "application/json")
    public DeckDTO getDeckByCardListAndHero(MinerDTO request){
        return getDecksService.getDeckByCardListAndHero(DeckRequestDTO.builder()
                .ids(request.getCardIds())
                .hero(request.getParams().get(Constants.HERO))
                .build());
    }

    @GetMapping(path="/decksByCards",consumes = "application/json" , produces = "application/json")
    public DeckDTO getDeckByCardListAutoHero(MinerDTO request){
        return getDecksService.getDeckByCardListAutoHero(DeckRequestDTO.builder()
                .ids(request.getCardIds())
                .build());
    }

    @PostMapping(path="/decksByCode",consumes = "application/json" , produces = "application/json")
    public DeckDTO getDeckByCode(@RequestBody MinerDTO request){
        System.out.println(request.getParams().get(Constants.CODE));
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
    public GetCardsResponseDTO getAllCards(MinerDTO request){
        return getCardsService.getAllCards(CardRequestDTO.builder()
                .page(request.getPage()).build());
    }

    @GetMapping(path="/cardsSort",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsSort(MinerDTO request){
        return getCardsService.getAllCardsSort(CardRequestDTO.builder()
                .page(request.getPage())
                .sort(request.getParams().get(Constants.SORT)).build());
    }

    @GetMapping(path="/cardsPageSize",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsSetPageSize(MinerDTO request){
        return getCardsService.getAllCardsSetPageSize(CardRequestDTO.builder()
                .page(request.getPage())
                .pageSize(request.getParams().get(Constants.PAGE_SIZE)).build());
    }

    @GetMapping(path="/cardsPageSizeSort",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByPageSetPageSizeSort(MinerDTO request){
        return getCardsService.getAllCardsByPageSetPageSizeSort(CardRequestDTO.builder()
                .page(request.getPage())
                .pageSize(request.getParams().get(Constants.PAGE_SIZE))
                .sort(request.getParams().get(Constants.SORT)).build());
    }

    @GetMapping(path="/cardsByManaCost",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByManaCost(MinerDTO request){
        return getCardsService.getAllCardsByManaCost(CardRequestDTO.builder()
                .page(request.getPage())
                .mana(request.getParams().get(Constants.MANA)).build());
    }

    @GetMapping(path="/cardsByManaCostAndAttack",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByManaCostAndAttack(MinerDTO request){
        return getCardsService.getAllCardsByManaCostAndAttack(CardRequestDTO.builder()
                .page(request.getPage())
                .mana(request.getParams().get(Constants.MANA))
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @GetMapping(path="/cardsByAttack",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByAttack(MinerDTO request){
        return getCardsService.getAllCardsByAttack(CardRequestDTO.builder()
                .page(request.getPage())
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @GetMapping(path="/cardsByType",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByType(MinerDTO request){
        return getCardsService.getAllCardsByType(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE)).build());
    }

    @GetMapping(path="/cardsByAttackAndType",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByTypeAndAttack(MinerDTO request){
        return getCardsService.getAllCardsByTypeAndAttack(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE))
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @GetMapping(path="/cardsByAttackAndManaCost",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByTypeAndManaCost(MinerDTO request){
        return getCardsService.getAllCardsByTypeAndManaCost(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE))
                .mana(request.getParams().get(Constants.MANA)).build());
    }

    @GetMapping(path="/cardsByAttackAndManaCostAndType",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByTypeAndAttackAndManaCost(MinerDTO request){
        return getCardsService.getAllCardsByTypeAndAttackAndManaCost(CardRequestDTO.builder()
                .page(request.getPage())
                .type(request.getParams().get(Constants.CARD_TYPE))
                .mana(request.getParams().get(Constants.MANA))
                .attack(request.getParams().get(Constants.ATTACK)).build());
    }

    @GetMapping(path="/cardsByHealth",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByHealth(MinerDTO request){
        return getCardsService.getAllCardsByHealth(CardRequestDTO.builder()
                .page(request.getPage())
                .health(request.getParams().get(Constants.HEALTH)).build());
    }

    @GetMapping(path="/cardsByGameMode",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsByGameMode(MinerDTO request){
        return getCardsService.getAllCardsByGameMode(CardRequestDTO.builder()
                .page(request.getPage())
                .gameMode(request.getParams().get(Constants.GAME_MODE)).build());
    }

    @GetMapping(path="/cardsBySpellSchool",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsBySpellSchool(MinerDTO request){
        return getCardsService.getAllCardsBySpellSchool(CardRequestDTO.builder()
                .page(request.getPage())
                .spellSchool(request.getParams().get(Constants.SPELL_SCHOOL)).build());
    }

    @GetMapping(path="/cardsBySet",consumes = "application/json" , produces = "application/json")
    public GetCardsResponseDTO getAllCardsBySet(MinerDTO request){
        return getCardsService.getAllCardsBySet(CardRequestDTO.builder()
                .page(request.getPage())
                .set(request.getParams().get(Constants.SET)).build());
    }

}
