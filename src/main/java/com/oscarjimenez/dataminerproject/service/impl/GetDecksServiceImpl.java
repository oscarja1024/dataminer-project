package com.oscarjimenez.dataminerproject.service.impl;

import com.oscarjimenez.dataminerproject.api.DTOS.DeckRequestDTO;
import com.oscarjimenez.dataminerproject.api.utils.CommonUtils;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.DeckDTO;
import com.oscarjimenez.dataminerproject.client.FeignBlizzardAPIGetDecks;
import com.oscarjimenez.dataminerproject.service.GetDecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetDecksServiceImpl implements GetDecksService {

    @Autowired
    FeignBlizzardAPIGetDecks feignBlizzardAPIGetDecks;

    @Autowired
    CommonUtils commonUtils;

    @Override
    public DeckDTO getDeckByCardListAndHero(DeckRequestDTO requestDeck) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetDecks.getDeckByCardListAndHero(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE, requestDeck.getIds(),requestDeck.getHero());

        return response;
    }

    @Override
    public DeckDTO getDeckByCardListAutoHero(DeckRequestDTO requestDeck) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetDecks.getDeckByCardListAutoHero(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE, requestDeck.getIds());

        return response;
    }

    @Override
    public DeckDTO getDeckByCode(DeckRequestDTO requestDeck) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetDecks.getDeckByCode(Constants.BEARER+token.getAccess_token()
                ,requestDeck.getCode(),Constants.LOCALE);

        return response;
    }
}
