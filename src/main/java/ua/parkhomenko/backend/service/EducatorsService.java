package ua.parkhomenko.backend.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.parkhomenko.backend.model.*;
import ua.parkhomenko.backend.repository.*;

import java.util.List;

@Slf4j
@NoArgsConstructor
@Component
public class EducatorsService {
    @Autowired
    ChildrenRepository childrenRepository;

    @Autowired
    RelativesRepository relativesRepository;

    @Autowired
    AlertMessagesRepository alertMessagesRepository;

    @Autowired
    ReviewsRepository reviewsRepository;

    @Autowired
    GroupsRepository groupsRepository;



    public List<Child> getChildrenByGroup(EducationGroup group) throws Exception {
        return childrenRepository.getAllChildrenByGroup(group.getGroupId());
    }

    public List<Relative> getRelativesByChild(Child child) throws Exception {
        return relativesRepository.getAllRelativesByChild(child.getChildId());
    }

    public Child getChildById(Integer childId) throws Exception {
        Child child = childrenRepository.findById(childId).get();
        if(child == null) {
            throw new Exception("Child search try by id: " + childId + " failed");
        }
        return child;
    }
    public EducationGroup getGroupById(Integer groupId) throws Exception {
        EducationGroup group = groupsRepository.findById(groupId).get();
        if(group == null) {
            throw new Exception("Group search try by id: " + groupId + " failed");
        }
        return group;
    }
    public AlertMessage getAlertById(Integer alertId) throws Exception {
        AlertMessage alert = alertMessagesRepository.findById(alertId).get();
        if(alert == null) {
            throw new Exception("Alert search try by id: " + alertId + " failed");
        }
        return alert;
    }

    public AlertMessage createCommentUnderAlertMessage(AlertMessage alert, String comment) throws Exception {
        alert.setEducatorReviewMessage(comment);
        return alertMessagesRepository.save(alert);
    }

    public List<Review> getAllReviewsByAlertMessage(AlertMessage alert) throws Exception {
        return reviewsRepository.getAllReviewsForAlert(alert.getAlertMessageId());
    }
}
