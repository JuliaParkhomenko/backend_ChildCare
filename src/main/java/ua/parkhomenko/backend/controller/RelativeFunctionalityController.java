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
import ua.parkhomenko.backend.model.Relative;
import ua.parkhomenko.backend.model.Review;
import ua.parkhomenko.backend.service.RelativesService;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@RestController
@RequestMapping("/relatives")
public class RelativeFunctionalityController {
    @Autowired
    RelativesService relativesService;

    @GetMapping("/getAllChildren")
    public List<ChildForRelativeDTO> getAllChildren(@RequestParam String email) throws Exception {
        Relative relative = relativesService.getRelativeByEmail(email);
        List<Child> children = relativesService.getAllChildren(email);
        return children.stream().map(
                child -> ChildForRelativeDTO.packChild(child)
        ).collect(Collectors.toList());
    }

    @GetMapping("/getCertainChildEducatorsEmail")
    public List<String> getCertainChildEducatorsEmail(@RequestParam Integer childId) throws Exception {
        Child child = relativesService.getChildById(childId);
        List<String> emails = relativesService.getCertainChildEducatorsEmail(child);
        return emails;
    }

    @GetMapping("/getAllChildAlerts")
    public List<AlertMessage> getAllChildAlerts(@RequestParam Integer childId) throws Exception {
        Child child = relativesService.getChildById(childId);
        List<AlertMessage> alerts = relativesService.getCertainChildAlerts(child);
        return alerts;
    }

    @GetMapping("/getAllReviewsForCertainAlert")
    public List<Review> getAllReviewsForCertainAlert(@RequestParam Integer alertId) throws Exception {
        AlertMessage alert = relativesService.getAlertMessage(alertId);
        List<Review> reviews = relativesService.getAllReviewsForAlert(alert);
        return reviews;
    }
}
