package org.festpass.festpass.controller;

import org.festpass.festpass.entity.FestEvent;
import org.festpass.festpass.repository.FestEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final FestEventRepository repository;

    public EventController(FestEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public FestEvent addEvent(@RequestBody FestEvent event) {
        return repository.save(event);
    }

    @GetMapping
    public List<FestEvent> getAllEvents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public FestEvent getEvent(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}