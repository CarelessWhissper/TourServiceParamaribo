package sr.unasat.library.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


import org.springframework.stereotype.Service;
import sr.unasat.library.entity.Ticket;
import sr.unasat.library.repository.TicketRepo;
import sr.unasat.library.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {


    private TicketRepo ticketRepo;

    @Override
   public Ticket createTicket(Ticket ticket){
        return ticketRepo.save(ticket);
    }

   @Override
   public Ticket getTicketById(Long ticketId){
        Optional<Ticket> optionalTicket = ticketRepo.findById(ticketId);
        return  optionalTicket.get();
   }

   @Override
    public List<Ticket>getAllTickets(){
        return ticketRepo.findAll();
   }

   @Override
    public Ticket updateTicket(Ticket ticket){
        Ticket existingTicket = ticketRepo.findById(ticket.getId()).get();
        existingTicket.setDepartingLocation(ticket.getDepartingLocation());
        existingTicket.setDepartDate(ticket.getDepartDate());
        existingTicket.setReturnDate(ticket.getReturnDate());
        existingTicket.setTourist(ticket.getTourist());

        Ticket updatedTicket = ticketRepo.save(existingTicket);

        return updatedTicket;
   }

   @Override
    public void deleteTicket(Long ticketId){
        ticketRepo.deleteById(ticketId);
   }
}
