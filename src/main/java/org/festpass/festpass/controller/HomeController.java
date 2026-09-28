package org.festpass.festpass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/events")
    public String events() {
        return "events";
    }

    @GetMapping("/event-details")
    public String eventDetails() {
        return "event-details";
    }

    @GetMapping("/book")
    public String book() {
        return "book";
    }

    @GetMapping("/bookings")
    public String bookings() {
        return "bookings";
    }

    @GetMapping("/timings")
    public String timings() {
        return "timings";
    }

    @GetMapping("/tickets")
    public String tickets() {
        return "tickets";
    }

    @GetMapping("/scanner")
    public String scanner() {
        return "scanner";
    }
}