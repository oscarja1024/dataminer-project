package com.oscarjimenez.dataminerproject.service.impl;

import com.oscarjimenez.dataminerproject.api.DTOS.CardBackRequest;
import com.oscarjimenez.dataminerproject.api.utils.CommonUtils;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.CardBacksResponseDTO;
import com.oscarjimenez.dataminerproject.client.FeignBlizzardAPIGetCardBacks;
import com.oscarjimenez.dataminerproject.service.GetCardsBacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCardBacksServiceImpl implements GetCardsBacksService {

    @Autowired
    FeignBlizzardAPIGetCardBacks feignBlizzardAPIGetCardBacks;

    @Autowired
    CommonUtils commonUtils;

    @Override
    public CardBacksResponseDTO getCardBacksById(CardBackRequest cardbacksRequest) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCardBacks.getCardBacksById(Constants.BEARER+token.getAccess_token()
                ,cardbacksRequest.getIdorSlug(),Constants.LOCALE);

        return response;
    }

    @Override
    public CardBacksResponseDTO getCardBacksSort(CardBackRequest cardBackRequest) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCardBacks.getCardBacksSort(Constants.BEARER+token.getAccess_token()
                ,cardBackRequest.getSort(),Constants.LOCALE,cardBackRequest.getPage());

        return response;
    }

    @Override
    public CardBacksResponseDTO getCardBacks(CardBackRequest cardBackRequest) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCardBacks.getCardBacks(Constants.BEARER+token.getAccess_token()
                ,Constants.LOCALE,cardBackRequest.getPage());

        return response;
    }


    @Override
    public CardBacksResponseDTO getCardBacksByCardBackCategory(CardBackRequest cardBackRequest) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCardBacks.getCardBacksByCardBackCategory(Constants.BEARER+token.getAccess_token()
                ,cardBackRequest.getCategory(),Constants.LOCALE,cardBackRequest.getPage());

        return response;
    }

    @Override
    public CardBacksResponseDTO getCardBacksByCardBackCategorySort(CardBackRequest cardBackRequest) {

        var token = commonUtils.getToken();

        var response = feignBlizzardAPIGetCardBacks.getCardBacksByCardBackCategorySort(Constants.BEARER+token.getAccess_token()
                ,cardBackRequest.getCategory(),Constants.LOCALE,cardBackRequest.getSort(),cardBackRequest.getPage());

        return response;
    }
}
