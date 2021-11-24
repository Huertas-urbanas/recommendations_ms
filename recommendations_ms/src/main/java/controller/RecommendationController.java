package controller;
import org.springframework.web.bind.annotation.*;
import com.huerta.recommendations_ms.models.Recommendation;
import repository.RecommendationRepository;
import java.util.List;
import java.util.Date;

@RestController

public class RecommendationController {
   private  RecommendationRepository recommendationRepository;

    public RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @GetMapping("/recommendations/{id}")
    List<Recommendation> getRecommendations(){
        return recommendationRepository.findAll();
    }

    // Find by title
    @GetMapping("/{title}")
    List<Recommendation> getRecommendationbyTitle(@PathVariable String title){
        return recommendationRepository.findByTitleLike(title);
    }

    @PostMapping("/recommendations/{id}")
    Recommendation  createRecommendation(@RequestBody Recommendation recommendation){
        Recommendation.setReleaseDate(new Date());
        return recommendationRepository.save(recommendation);


    }
    @PutMapping("/recommendations/{id}")

    Recommendation updateRecommendation (@PathVariable Integer id, @RequestBody Recommendation recommendation ){
        Recommendation.setId(id);
        return recommendationRepository.save(recommendation );

    }

    @DeleteMapping("/recommendations/{id}")
    void deleteRecommendation(@PathVariable  Integer id){
        Recommendation recommendation = new Recommendation(id);
        recommendationRepository.delete(recommendation );
    }
}
