package com.oscarjimenez.dataminerproject.service;

import com.oscarjimenez.dataminerproject.api.DTOS.DeckRequestDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.DeckDTO;

public interface GetDecksService {

    DeckDTO getDeckByCardListAndHero(DeckRequestDTO requestDeck);

    DeckDTO getDeckByCardListAutoHero(DeckRequestDTO requestDeck);

    DeckDTO getDeckByCode(DeckRequestDTO requestDeck);

}
