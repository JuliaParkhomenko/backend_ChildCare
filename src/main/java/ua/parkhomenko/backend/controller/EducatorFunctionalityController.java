package ua.parkhomenko.backend.controller;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.parkhomenko.backend.dto.ChildForRelativeDTO;
import ua.parkhomenko.backend.model.AlertMessage;
import ua.parkhomenko.backend.model.Child;
import ua.parkhomenko.backend.model.EducationGroup;
import ua.parkhomenko.backend.model.Review;
import ua.parkhomenko.backend.service.EducatorsService;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping("/educators")

public class EducatorFunctionalityController {
    @Autowired
    EducatorsService educatorsService;

    @GetMapping("/getChildrenByGroup")
    public List<ChildForRelativeDTO> getChildrenByGroup(@RequestParam Integer groupId) throws Exception {
        EducationGroup group = educatorsService.getGroupById(groupId);
        return educatorsService.getChildrenByGroup(group).stream().map(
                child -> ChildForRelativeDTO.packChild(child)
        ).collect(Collectors.toList());
    }

    @GetMapping("/getCertainChildRelativesEmail")
    public List<String> getCertainChildRelativesEmail(@RequestParam Integer childId) throws Exception {
        Child child = educatorsService.getChildById(childId);
        return educatorsService.getRelativesByChild(child).stream().map(
                relative -> relative.getEmail()
        ).collect(Collectors.toList());
    }

    @GetMapping("/createCommentUnderAlertMessage")
    public boolean createCommentUnderAlertMessage(@RequestParam Integer alertId, @RequestParam String message) throws Exception {
        AlertMessage alert = educatorsService.getAlertById(alertId);
        return educatorsService.createCommentUnderAlertMessage(alert, message).getEducatorReviewMessage().equals(message);
    }

    @GetMapping("/getAllReviewsByAlertMessage")
    public List<Review> getAllReviewsByAlertMessage(@RequestParam Integer alertId) throws Exception {
        AlertMessage alert = educatorsService.getAlertById(alertId);
        return educatorsService.getAllReviewsByAlertMessage(alert);
    }
}
