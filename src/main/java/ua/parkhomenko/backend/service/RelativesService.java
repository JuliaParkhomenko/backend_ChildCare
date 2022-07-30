package ua.parkhomenko.backend.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.parkhomenko.backend.model.AlertMessage;
import ua.parkhomenko.backend.model.Child;
import ua.parkhomenko.backend.model.Relative;
import ua.parkhomenko.backend.model.Review;
import ua.parkhomenko.backend.repository.AlertMessagesRepository;
import ua.parkhomenko.backend.repository.ChildrenRepository;
import ua.parkhomenko.backend.repository.RelativesRepository;
import ua.parkhomenko.backend.repository.ReviewsRepository;

import java.util.List;

@Slf4j
@NoArgsConstructor
@Component
public class RelativesService {
    @Autowired
    ChildrenRepository childrenRepository;

    @Autowired
    RelativesRepository relativesRepository;

    @Autowired
    AlertMessagesRepository alertMessagesRepository;

    @Autowired
    ReviewsRepository reviewsRepository;

    public Relative getRelativeByEmail(String email) throws Exception {
        Relative relative = relativesRepository.findById(email).get();
        if(relative == null) {
            throw new Exception("Relative search try by email: " + email + " failed");
        }
        return relative;
    }

    public List<Child> getAllChildren(String relativeEmail) {
        return childrenRepository.getAllChildrenOfRelative(relativeEmail);
    }

    public Child getChildById(Integer childId) throws Exception {
        Child child = childrenRepository.findById(childId).get();
        if(child == null) {
            throw new Exception("Child search try by id: " + childId + " failed");
        }
        return child;
    }

    public List<String> getCertainChildEducatorsEmail(Child child) {
        return childrenRepository.getAllChildEducatorsEmails(child.getGroup().getGroupId());
    }

    public List<AlertMessage> getCertainChildAlerts(Child child) {
        return alertMessagesRepository.getAllChildAlerts(child.getChildId());
    }

    public AlertMessage getAlertMessageByID(Integer alertId) throws Exception {
        AlertMessage alert = alertMessagesRepository.findById(alertId).get();
        if(alert == null) {
            throw new Exception("AlertMessage search try: " + alertId + " failed");
        }
        return alert;
    }
    public Review getReviewById(Integer reviewId) throws Exception {
        Review review = reviewsRepository.findById(reviewId).get();
        if(review == null) {
            throw new Exception("Review search try: " + reviewId + " failed");
        }
        return review;
    }

    public List<Review> getAllReviewsForAlert(AlertMessage alert) {
        return reviewsRepository.getAllReviewsForAlert(alert.getAlertMessageId());
    }

    public Review createReview(AlertMessage alert, String message, String email) {
        Review newReview = new Review();
        newReview.setReviewMessage(message);
        newReview.setRelativeEmail(email);
        newReview.setAlertMessage(alert);
        return reviewsRepository.save(newReview);
    }

    public Review updateMark(Review review, Integer mark) {
        review.setMark(mark);
        return reviewsRepository.save(review);
    }
}
