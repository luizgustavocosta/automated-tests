package com.costa.luiz.automatedtests.netflix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class NetflixServiceTest {

    NetflixService netflixService;

    @Mock
    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        netflixService = new NetflixService(recommendationService);
    }

    @Test
    void getUserRecommendation() {
        var user = "Sherlock";
        doReturn(Arrays.asList("Matrix", "Matrix reloaded", "Matrix revolutions"))
                .when(recommendationService)
                .getRecommendationsBy(user);

        var recommendations = netflixService.getUserRecommendation(user);
        verify(recommendationService).getRecommendationsBy(user);
        assertEquals(3, recommendations.size());
    }
}
