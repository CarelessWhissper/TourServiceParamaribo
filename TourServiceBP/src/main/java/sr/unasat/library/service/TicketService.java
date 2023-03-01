package sr.unasat.library.service;

import java.util.List;


import org.springframework.stereotype.Service;
import sr.unasat.library.entity.Ticket;

@Service
public interface TicketService {

   Ticket createTicket (Ticket ticket);

   Ticket getTicketById(Long TicketId);

   List<Ticket>getAllTickets();

   Ticket updateTicket( Ticket ticket);

   void deleteTicket(Long TicketId);


}
