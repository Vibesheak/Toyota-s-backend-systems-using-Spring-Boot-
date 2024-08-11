package com.ToyotaWeb.Toyota.Controller;

import com.ToyotaWeb.Toyota.Model.RatingRanking;
import com.ToyotaWeb.Toyota.Service.RatingRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating_ranking")
@CrossOrigin(origins = "*")
public class RatingRankingController {

    @Autowired
    private RatingRankingService ratingRankingService;

    @PostMapping
    public ResponseEntity<RatingRanking> saveRatingRanking(@RequestBody RatingRanking ratingRanking) {
        return new ResponseEntity<>(ratingRankingService.saveRatingRanking(ratingRanking), HttpStatus.CREATED);
    }

    @GetMapping
    public List<RatingRanking> getAllRatingRankings() {
        return ratingRankingService.getAllRatingRankings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingRanking> getRatingRankingById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(ratingRankingService.getRatingRankingById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingRanking> updateRatingRanking(@PathVariable("id") Long id, @RequestBody RatingRanking ratingRanking) {
        return new ResponseEntity<>(ratingRankingService.updateRatingRanking(ratingRanking, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRatingRanking(@PathVariable("id") Long id) {
        ratingRankingService.deleteRatingRanking(id);
        return new ResponseEntity<>("Rating & Ranking record deleted successfully", HttpStatus.OK);
    }
}
