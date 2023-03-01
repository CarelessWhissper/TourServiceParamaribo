package sr.unasat.library.service;

import java.util.List;
import java.util.Optional;

import sr.unasat.library.entity.Ticket;

public interface TicketService {

    Ticket add(Ticket ticket);

    List get();

    Optional get(Long id);

    void delete(Long id);
}
