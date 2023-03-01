package sr.unasat.library.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sr.unasat.library.entity.Ticket;
import sr.unasat.library.repository.TicketRepo;
import sr.unasat.library.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;

    @Override
    public Ticket add(Ticket ticket){
        return ticketRepo.save(ticket);
    }

    @Override
    public List get(){
        return ticketRepo.findAll();
    }

    @Override
    public Optional get(Long id){
        return ticketRepo.findById(id);
    }

    @Override
    public void delete(Long id){
        if (get(id).isPresent()) {
            ticketRepo.delete((Ticket) get(id).get());
        }
    }
}
