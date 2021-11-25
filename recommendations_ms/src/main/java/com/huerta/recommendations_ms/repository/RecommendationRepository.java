package com.huerta.recommendations_ms.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.huerta.recommendations_ms.models.Recommendation;
import java.util.*;

public interface RecommendationRepository extends MongoRepository <Recommendation, String> {
    List<Recommendation> findByTitleLike(String title);
    Recommendation findByid(String id);
}


