package com.costa.luiz.automatedtests.netflix;

import java.util.List;

public class NetflixService {

    private final RecommendationService recommendationService;

    public NetflixService(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    public List<String> getUserRecommendation(String user) {
        return
                recommendationService.getRecommendationsBy(user);
    }
}
