package xyz.junjie.xu.daos;

import java.util.List;

import javax.persistence.Query;

import xyz.junjie.xu.compositeIds.ReviewId;
import xyz.junjie.xu.entities.Review;
import xyz.junjie.xu.interfaces.ReviewI;

public class ReviewDao extends AbstractDao implements ReviewI{

	@Override
	public List<Review> getReviewsByStyleId(int styleId) {
		try {
			connect();
			Query query = em.createQuery("SELECT r from Review r WHERE r.id.styleId = :styleId");
			query.setParameter("styleId", styleId);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

	@Override
	public int addReview(Review review) {
		try {
			connect();
			em.getTransaction().begin();
			em.persist(review);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			disconnect();
		}
	}

	@Override
	public Review getReviewByStyleIdAndUsername(int styleId, String username) {
		try {
			connect();
			return em.find(Review.class, new ReviewId(styleId, username));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

}
