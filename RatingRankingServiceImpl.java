package com.ToyotaWeb.Toyota.Service.impl;

import com.ToyotaWeb.Toyota.Model.RatingRanking;
import com.ToyotaWeb.Toyota.Repository.RatingRankingRepository;
import com.ToyotaWeb.Toyota.Service.RatingRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingRankingServiceImpl implements RatingRankingService {

    @Autowired
    private RatingRankingRepository ratingRankingRepository;

    @Override
    public RatingRanking saveRatingRanking(RatingRanking ratingRanking) {
        return ratingRankingRepository.save(ratingRanking);
    }

    @Override
    public List<RatingRanking> getAllRatingRankings() {
        return ratingRankingRepository.findAll();
    }

    @Override
    public RatingRanking getRatingRankingById(long id) {
        Optional<RatingRanking> ratingRanking = ratingRankingRepository.findById(id);
        if (ratingRanking.isPresent()) {
            return ratingRanking.get();
        } else {
            throw new RuntimeException("Rating & Ranking record not found for id: " + id);
        }
    }

    @Override
    public RatingRanking updateRatingRanking(RatingRanking ratingRanking, long id) {
        RatingRanking existingRatingRanking = ratingRankingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Rating & Ranking record not found for id: " + id)
        );
        existingRatingRanking.setVehicleId(ratingRanking.getVehicleId());
        existingRatingRanking.setCustomerId(ratingRanking.getCustomerId());
        existingRatingRanking.setRating(ratingRanking.getRating());
        existingRatingRanking.setReview(ratingRanking.getReview());
        existingRatingRanking.setRanking(ratingRanking.getRanking());
        ratingRankingRepository.save(existingRatingRanking);
        return existingRatingRanking;
    }

    @Override
    public void deleteRatingRanking(long id) {
        ratingRankingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Rating & Ranking record not found for id: " + id)
        );
        ratingRankingRepository.deleteById(id);
    }
}
