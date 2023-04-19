package com.oscarjimenez.dataminerproject.service;


import com.oscarjimenez.dataminerproject.api.DTOS.CardBackRequest;
import com.oscarjimenez.dataminerproject.client.DTOS.CardBacksResponseDTO;

public interface GetCardsBacksService {

    CardBacksResponseDTO getCardBacksById(CardBackRequest cardbacksRequest);

    CardBacksResponseDTO getCardBacksSort(CardBackRequest cardBackRequest);

    CardBacksResponseDTO getCardBacks(CardBackRequest cardBackRequest);

    CardBacksResponseDTO getCardBacksByCardBackCategory(CardBackRequest cardBackRequest);

    CardBacksResponseDTO getCardBacksByCardBackCategorySort(CardBackRequest cardBackRequest);

}
