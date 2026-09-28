package org.festpass.festpass.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "fest_events")
public class FestEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int capacity;

    private double ticketPrice;

    private int ticketsIssued = 0;

    private int ticketsUsed = 0;

    private String imageUrl;

    private LocalDate eventDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private String venue;

    private String category;

    private String chiefGuestName;

    private String chiefGuestRole;

    private String chiefGuestImage;

    public FestEvent() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketsIssued() {
        return ticketsIssued;
    }

    public void setTicketsIssued(int ticketsIssued) {
        this.ticketsIssued = ticketsIssued;
    }

    public int getTicketsUsed() {
        return ticketsUsed;
    }

    public void setTicketsUsed(int ticketsUsed) {
        this.ticketsUsed = ticketsUsed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChiefGuestName() {
        return chiefGuestName;
    }

    public void setChiefGuestName(String chiefGuestName) {
        this.chiefGuestName = chiefGuestName;
    }

    public String getChiefGuestRole() {
        return chiefGuestRole;
    }

    public void setChiefGuestRole(String chiefGuestRole) {
        this.chiefGuestRole = chiefGuestRole;
    }

    public String getChiefGuestImage() {
        return chiefGuestImage;
    }

    public void setChiefGuestImage(String chiefGuestImage) {
        this.chiefGuestImage = chiefGuestImage;
    }
}