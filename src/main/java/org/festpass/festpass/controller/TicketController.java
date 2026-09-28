package org.festpass.festpass.controller;

import org.festpass.festpass.entity.Attendee;
import org.festpass.festpass.entity.FestEvent;
import org.festpass.festpass.entity.Ticket;
import org.festpass.festpass.repository.AttendeeRepository;
import org.festpass.festpass.repository.FestEventRepository;
import org.festpass.festpass.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketRepository ticketRepository;
    private final FestEventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public TicketController(TicketRepository ticketRepository,
                            FestEventRepository eventRepository,
                            AttendeeRepository attendeeRepository) {

        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }

    // Buy Ticket
    @PostMapping("/buy")
    public Ticket buyTicket(@RequestParam Long eventId,
                            @RequestParam String name,
                            @RequestParam String email) {

        FestEvent event = eventRepository.findById(eventId).orElseThrow();

        // Check capacity
        if (event.getTicketsIssued() >= event.getCapacity()) {
            throw new RuntimeException("Event is full");
        }

        // Check duplicate booking
        if (ticketRepository.existsByAttendee_EmailAndEvent_Id(email, eventId)) {
            throw new RuntimeException("Already booked for this event");
        }

        // Create attendee
        Attendee attendee = new Attendee();
        attendee.setName(name);
        attendee.setEmail(email);

        attendee = attendeeRepository.save(attendee);

        // Create ticket
        Ticket ticket = new Ticket();

        ticket.setQrCode(UUID.randomUUID().toString());
        ticket.setEvent(event);
        ticket.setAttendee(attendee);

        // Increase tickets issued
        event.setTicketsIssued(event.getTicketsIssued() + 1);

        eventRepository.save(event);

        return ticketRepository.save(ticket);
    }

    // QR Check-in
    @PostMapping("/check-in")
    public String checkIn(@RequestParam String qrCode) {

        Ticket ticket = ticketRepository.findByQrCode(qrCode).orElse(null);

        // Invalid QR
        if (ticket == null) {
            return "Invalid QR code";
        }

        // Already used QR
        if (ticket.isUsed()) {
            return "Ticket already used";
        }

        // Mark ticket as used
        ticket.setUsed(true);
        ticketRepository.save(ticket);

        // Increase attendance
        FestEvent event = ticket.getEvent();

        event.setTicketsUsed(event.getTicketsUsed() + 1);

        eventRepository.save(event);

        return "Check-in successful";
    }
    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }
    @GetMapping("/my-bookings")
    public java.util.List<Ticket> getMyBookings(@RequestParam String email) {
        return ticketRepository.findByAttendee_Email(email);
    }
}