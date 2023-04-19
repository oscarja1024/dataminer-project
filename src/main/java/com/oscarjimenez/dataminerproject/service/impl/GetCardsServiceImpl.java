package com.oscarjimenez.dataminerproject.service.impl;

import com.oscarjimenez.dataminerproject.api.DTOS.CardRequestDTO;
import com.oscarjimenez.dataminerproject.api.utils.CommonUtils;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.GetCardsResponseDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.GetOneCardResponseDTO;
import com.oscarjimenez.dataminerproject.client.FeignBlizzardAPIGetCards;
import com.oscarjimenez.dataminerproject.service.GetCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCardsServiceImpl implements GetCardsService {

    @Autowired
    FeignBlizzardAPIGetCards feignBlizzardAPIGetCards;

    @Autowired
    CommonUtils commonUtils;

    @Override
    public GetOneCardResponseDTO getOneCardById(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getOneCardById(Constants.BEARER+token.getAccess_token()
                ,requestCards.getCardId(),Constants.LOCALE);

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCards(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCards(Constants.BEARER+token.getAccess_token()
               ,Constants.LOCALE,requestCards.getPage());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsSort(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsSort(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getSort());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsSetPageSize(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsSetPageSize(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getPageSize());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByPageSetPageSizeSort(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByPageSetPageSizeSort(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getPageSize(), requestCards.getSort());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByManaCost(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByManaCost(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getMana());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByManaCostAndAttack(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByManaCostAndAttack(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getMana(),requestCards.getAttack());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByAttack(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByAttack(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getAttack());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByType(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByType(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getType());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByTypeAndAttack(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByTypeAndAttack(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getType(),requestCards.getAttack());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByTypeAndManaCost(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByTypeAndManaCost(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getType(),requestCards.getMana());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByTypeAndAttackAndManaCost(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByTypeAndAttackAndManaCost(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage()
                ,requestCards.getType()
                ,requestCards.getAttack()
                ,requestCards.getMana());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByHealth(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByHealth(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getHealth());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsByGameMode(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsByGameMode(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getGameMode());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsBySpellSchool(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsBySpellSchool(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getSpellSchool());

        return response;
    }

    @Override
    public GetCardsResponseDTO getAllCardsBySet(CardRequestDTO requestCards) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCards.getAllCardsBySet(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,requestCards.getPage(),requestCards.getSet());

        return response;
    }
}
