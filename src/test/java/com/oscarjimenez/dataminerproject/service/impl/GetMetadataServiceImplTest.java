package com.oscarjimenez.dataminerproject.service.impl;

import com.oscarjimenez.dataminerproject.api.DTOS.CardBackRequest;
import com.oscarjimenez.dataminerproject.api.DTOS.MetadataRequest;
import com.oscarjimenez.dataminerproject.api.utils.CommonUtils;
import com.oscarjimenez.dataminerproject.api.utils.Constants;
import com.oscarjimenez.dataminerproject.client.DTOS.*;
import com.oscarjimenez.dataminerproject.client.FeignBlizzardAPIGetMetadata;
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
class GetMetadataServiceImplTest {

    @Mock
    CommonUtils commonUtils;

    @Mock
    FeignBlizzardAPIGetMetadata feignBlizzardAPIGetMetadata;

    @InjectMocks
    GetMetadataServiceImpl getMetadataService;

    @Test
    void getAllMetadata() {


        var token = BearerTokenResponseDTO.builder()
                .access_token("EUmyuB1Rrl1DxlVvdQYanEKW6bxScIyw67")
                .token_type("bearer")
                .sub("d201dd916cf04e109f9c52650dd9b29r")
                .expires_in(86399).build();

        //Accedemos al token del servicio
        when(commonUtils.getToken()).thenReturn(token);

        var expected = MetadataResponseDTO.builder()
                .spellSchools(List.of(SpellSchoolDTO.builder().build()))
                .rarities(List.of(RarityDTO.builder().build()))
                .numericFields(List.of(""))
                .mercenaryRoles(List.of(MercenaryRoleDTO.builder().build()))
                .minionTypes(List.of(MinionTypeDTO.builder().build()))
                .mercenaryFactions(List.of(MercenaryFactionDTO.builder().build()))
                .classes(List.of(ClassDTO.builder().build()))
                .gameModes(List.of(GameModeDTO.builder().build()))
                .keywords(List.of(KeyWordDTO.builder().build()))
                .filterableFields(List.of(""))
                .cardBackCategories(List.of(CardBackCategoryDTO.builder().build()))
                .arenaIds(List.of(""))
                .setGroups(List.of(SetGroupsDTO.builder().build()))
                .sets(List.of(SetDTO.builder().build()))
                .types(List.of(TypeDTO.builder().build())).build();

        when(feignBlizzardAPIGetMetadata.getAllMetadata("Bearer "+token.getAccess_token(), Constants.LOCALE)).thenReturn(expected);

        var request = MetadataRequest.builder().build();

        var actual = getMetadataService.getAllMetadata(request);

        assertEquals(expected,actual);
    }
}