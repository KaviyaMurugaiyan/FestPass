package org.festpass.festpass.controller;

import org.festpass.festpass.entity.FestEvent;
import org.festpass.festpass.repository.FestEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final FestEventRepository eventRepository;

    public DashboardController(FestEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<FestEvent> getDashboardEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{eventId}")
    public FestEvent getEventDashboard(@PathVariable Long eventId) {
        return eventRepository.findById(eventId).orElseThrow();
    }
}