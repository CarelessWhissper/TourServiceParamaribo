package sr.unasat.library.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sr.unasat.library.entity.Ticket;
import sr.unasat.library.service.TicketService;


@RestController
@RequestMapping("/api")
public class TicketController
{
    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        try {
            List<Ticket> list = ticketService.get();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTickets(@PathVariable Long id) {
        Optional<Ticket> tickets = ticketService.get(id);

        if (tickets.isPresent()) {
            return new ResponseEntity<Ticket>(tickets.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/tickets")
    public ResponseEntity<Ticket> saveTickets(@RequestBody Ticket ticket) {
        try {
            return new ResponseEntity<Ticket>(ticketService.add(ticket), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/tickets")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        try {
            return new ResponseEntity<Ticket>(ticketService.add(ticket), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Ticket>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<HttpStatus> deleteTicket(@PathVariable Long id) {
        try {
            ticketService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
