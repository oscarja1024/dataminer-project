package com.oscarjimenez.dataminerproject.service;

import com.oscarjimenez.dataminerproject.api.DTOS.CardRequestDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.GetCardsResponseDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.GetOneCardResponseDTO;

public interface GetCardsService {


    GetOneCardResponseDTO getOneCardById(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCards(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsSort(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsSetPageSize(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByPageSetPageSizeSort(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByManaCost(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByManaCostAndAttack(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByAttack(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByType(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByTypeAndAttack(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByTypeAndManaCost(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByTypeAndAttackAndManaCost(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByHealth(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsByGameMode(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsBySpellSchool(CardRequestDTO requestCards);

    GetCardsResponseDTO getAllCardsBySet(CardRequestDTO requestCards);

}
