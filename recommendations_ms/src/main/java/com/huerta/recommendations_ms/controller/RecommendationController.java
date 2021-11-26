package com.huerta.recommendations_ms.controller;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import com.huerta.recommendations_ms.models.Recommendation;
import com.huerta.recommendations_ms.repository.RecommendationRepository;
import com.huerta.recommendations_ms.exceptions.RecommendationNotFoundException;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/recommendations")

public class RecommendationController {
   private final RecommendationRepository recommendationRepository;

    public RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @GetMapping()
    List<Recommendation> getRecommendations(){
        return recommendationRepository.findAll();
    }

    // Find by title
    @GetMapping("/findByTitle/{title}")
    List<Recommendation> getRecommendationbyTitle(@PathVariable String title){
        return recommendationRepository.findByTitleLike(title);

    }

    // find by id of recommendation
    @GetMapping("/findById/{id}")
    Recommendation getRecommendationById(@PathVariable String id){
        Recommendation idRecommendation = recommendationRepository.findById(id).orElse(null);

        if (idRecommendation == null)
            throw new RecommendationNotFoundException("No se encontro una recomendación con el id: "+id);

        return idRecommendation;
    }

    @PostMapping()
    Recommendation  createRecommendation(@RequestBody Recommendation recommendation){
        recommendation.setReleaseDate(new Date());
        return recommendationRepository.save(recommendation);

    }
    @PutMapping("/{id}")

    Recommendation updateRecommendation (@PathVariable String id, @RequestBody Recommendation recommendation){
        recommendation.setId(id);
        return recommendationRepository.save(recommendation);

    }

    @DeleteMapping("/{id}")
    void deleteRecommendation(@PathVariable  String id){
        Recommendation recommendation = new Recommendation(id);
        recommendationRepository.delete(recommendation);
    }
}
