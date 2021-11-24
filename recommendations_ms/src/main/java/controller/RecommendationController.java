package controller;
import org.springframework.web.bind.annotation.*;
import com.huerta.recommendations_ms.models.Recommendation;
import repository.RecommendationRepository;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/recommendations")

public class RecommendationController {
   private  RecommendationRepository recommendationRepository;

    public RecommendationController(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @GetMapping()
    List<Recommendation> getRecommendations(){
        return recommendationRepository.findAll();
    }

    // Find by title
    @GetMapping("/{title}")
    List<Recommendation> getRecommendationbyTitle(@PathVariable String title){
        return recommendationRepository.findByTitleLike(title);
    }

    @PostMapping()
    Recommendation  createRecommendation(@RequestBody Recommendation recommendation){
        Recommendation.setReleaseDate(new Date());
        return recommendationRepository.save(recommendation);

    }
    @PutMapping("/{id}")

    Recommendation updateRecommendation (@PathVariable Integer id, @RequestBody Recommendation recommendation ){
        Recommendation.setId(id);
        return recommendationRepository.save(recommendation );

    }

    @DeleteMapping("/{id}")
    void deleteRecommendation(@PathVariable  Integer id){
        Recommendation recommendation = new Recommendation(id);
        recommendationRepository.delete(recommendation );
    }
}
