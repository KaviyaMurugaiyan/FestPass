package org.festpass.festpass.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String qrCode;

    private boolean used = false;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private FestEvent event;

    @ManyToOne
    @JoinColumn(name = "attendee_id")
    private Attendee attendee;

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public FestEvent getEvent() {
        return event;
    }

    public void setEvent(FestEvent event) {
        this.event = event;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }
}