package org.festpass.festpass.repository;

import org.festpass.festpass.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByQrCode(String qrCode);

    boolean existsByAttendee_EmailAndEvent_Id(String email, Long eventId);

    List<Ticket> findByAttendee_Email(String email);
}