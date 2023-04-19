package com.oscarjimenez.dataminerproject.service.impl;

import com.oscarjimenez.dataminerproject.api.DTOS.CardBackRequest;
import com.oscarjimenez.dataminerproject.api.utils.CommonUtils;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.BearerTokenResponseDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.CardBacksDTO;
import com.oscarjimenez.dataminerproject.client.DTOS.CardBacksResponseDTO;
import com.oscarjimenez.dataminerproject.client.FeignBlizzardAPIGetCardBacks;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCardBacksServiceImplTest {


    @Mock
    FeignBlizzardAPIGetCardBacks feignBlizzardAPIGetCardBacks;

    @Mock
    CommonUtils commonUtils;

    @InjectMocks
    GetCardBacksServiceImpl getCardBacksService;

    @Test
    void getCardBacksById() {

        var token = BearerTokenResponseDTO.builder()
                .access_token("EUmyuB1Rrl1DxlVvdQYanEKW6bxScIyw67")
                .token_type("bearer")
                .sub("d201dd916cf04e109f9c52650dd9b29r")
                .expires_in(86399).build();

        //Accedemos al token del servicio
        when(commonUtils.getToken()).thenReturn(token);

        var expected = CardBacksResponseDTO.builder()
                .cardBacks(List.of(CardBacksDTO.builder().build()))
                .cardCount(1)
                .page(1)
                .pageCount(12).build();

        //Accedemos al servicio
        when(feignBlizzardAPIGetCardBacks.getCardBacksById("Bearer "+token.getAccess_token(),"12", Constants.LOCALE)).thenReturn(expected);

        var request = CardBackRequest.builder().page("1").idorSlug("12").build();

        var actual = getCardBacksService.getCardBacksById(request);

        assertEquals(expected, actual);
    }

    @Test
    void getCardBacksTest(){

        var token = BearerTokenResponseDTO.builder()
                .access_token("EUmyuB1Rrl1DxlVvdQYanEKW6bxScIyw67")
                .token_type("bearer")
                .sub("d201dd916cf04e109f9c52650dd9b29r")
                .expires_in(86399).build();

        //Accedemos al token del servicio
        when(commonUtils.getToken()).thenReturn(token);

        var expected = CardBacksResponseDTO.builder()
                .cardBacks(List.of(CardBacksDTO.builder().build()))
                .cardCount(100)
                .page(1)
                .pageCount(12).build();

        //Accedemos al servicio
        when(feignBlizzardAPIGetCardBacks.getCardBacks("Bearer "+token.getAccess_token(), Constants.LOCALE,"1")).thenReturn(expected);

        var request = CardBackRequest.builder().page("1").build();

        var actual = getCardBacksService.getCardBacks(request);

        assertEquals(expected, actual);
    }

    @Test
    void getCardBacksSort() {

        var token = BearerTokenResponseDTO.builder()
                .access_token("EUmyuB1Rrl1DxlVvdQYanEKW6bxScIyw67")
                .token_type("bearer")
                .sub("d201dd916cf04e109f9c52650dd9b29r")
                .expires_in(86399).build();

        //Accedemos al token del servicio
        when(commonUtils.getToken()).thenReturn(token);

        var expected = CardBacksResponseDTO.builder()
                .cardBacks(List.of(CardBacksDTO.builder().build()))
                .cardCount(100)
                .page(1)
                .pageCount(12).build();

        //Accedemos al servicio
        when(feignBlizzardAPIGetCardBacks.getCardBacksSort("Bearer "+token.getAccess_token(),"ascendent", Constants.LOCALE,"1")).thenReturn(expected);

        var request = CardBackRequest.builder().page("1").sort("ascendent").build();

        var actual = getCardBacksService.getCardBacksSort(request);

        assertEquals(expected, actual);
    }

    @Test
    void getCardBacksByCardBackCategory() {
        var token = BearerTokenResponseDTO.builder()
                .access_token("EUmyuB1Rrl1DxlVvdQYanEKW6bxScIyw67")
                .token_type("bearer")
                .sub("d201dd916cf04e109f9c52650dd9b29r")
                .expires_in(86399).build();

        //Accedemos al token del servicio
        when(commonUtils.getToken()).thenReturn(token);

        var expected = CardBacksResponseDTO.builder()
                .cardBacks(List.of(CardBacksDTO.builder().build()))
                .cardCount(100)
                .page(1)
                .pageCount(12).build();

        //Accedemos al servicio
        when(feignBlizzardAPIGetCardBacks.getCardBacksByCardBackCategory("Bearer "+token.getAccess_token()
                ,"category", Constants.LOCALE,"1")).thenReturn(expected);

        var request = CardBackRequest.builder().page("1").category("category").build();

        var actual = getCardBacksService.getCardBacksByCardBackCategory(request);

        assertEquals(expected, actual);
    }

    @Test
    void getCardBacksByCardBackCategorySort() {
        var token = BearerTokenResponseDTO.builder()
                .access_token("EUmyuB1Rrl1DxlVvdQYanEKW6bxScIyw67")
                .token_type("bearer")
                .sub("d201dd916cf04e109f9c52650dd9b29r")
                .expires_in(86399).build();

        //Accedemos al token del servicio
        when(commonUtils.getToken()).thenReturn(token);

        var expected = CardBacksResponseDTO.builder()
                .cardBacks(List.of(CardBacksDTO.builder().build()))
                .cardCount(100)
                .page(1)
                .pageCount(12).build();

        //Accedemos al servicio
        when(feignBlizzardAPIGetCardBacks.getCardBacksByCardBackCategorySort("Bearer "+token.getAccess_token()
                ,"category", Constants.LOCALE,"ascendent","1")).thenReturn(expected);

        var request = CardBackRequest.builder().page("1").sort("ascendent").category("category").build();

        var actual = getCardBacksService.getCardBacksByCardBackCategorySort(request);

        assertEquals(expected, actual);
    }
}