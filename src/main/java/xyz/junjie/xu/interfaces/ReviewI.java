package xyz.junjie.xu.interfaces;

import java.util.List;

import xyz.junjie.xu.entities.Review;

public interface ReviewI {
	List<Review> getReviewsByStyleId(int styleId);
	int addReview(Review review);
	Review getReviewByStyleIdAndUsername(int styleId, String username);
}
