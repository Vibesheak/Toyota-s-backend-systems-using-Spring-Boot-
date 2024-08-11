package com.ToyotaWeb.Toyota.Service;

import com.ToyotaWeb.Toyota.Model.RatingRanking;

import java.util.List;

public interface RatingRankingService {
    RatingRanking saveRatingRanking(RatingRanking ratingRanking);
    List<RatingRanking> getAllRatingRankings();
    RatingRanking getRatingRankingById(long id);
    RatingRanking updateRatingRanking(RatingRanking ratingRanking, long id);
    void deleteRatingRanking(long id);
}
