package sr.unasat.library.controller;

import java.util.List;
import java.util.Optional;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sr.unasat.library.entity.Ticket;
import sr.unasat.library.service.TicketService;

@CrossOrigin(maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/tickets")
public class TicketController
{
  private TicketService ticketService;

  //build create ticket REST API
   @PostMapping
   public ResponseEntity<Ticket>createTicket(@RequestBody Ticket ticket){
       Ticket savedTicket = ticketService.createTicket(ticket);
       return new ResponseEntity<>(savedTicket,HttpStatus.CREATED);
   }

   //build get ticket by Id REST API

    @GetMapping("{id}")
    public ResponseEntity<Ticket>getTicketById(@PathVariable("id")Long ticketId){
       Ticket ticket = ticketService.getTicketById(ticketId);
       return  new ResponseEntity<>(ticket,HttpStatus.OK);
    }

    //build get all tickets REST API

    @GetMapping
    public ResponseEntity<List<Ticket>>getAllTickets(){
       List<Ticket> tickets = ticketService.getAllTickets();

       return  new ResponseEntity<>(tickets,HttpStatus.OK);
    }

    //build update ticket REST API

    @PutMapping
    public ResponseEntity<Ticket> updateTicket(@PathVariable("id")Long ticketId,
                                               @RequestBody Ticket ticket){
       ticket.setId(ticketId);
       Ticket updatedTicket = ticketService.updateTicket(ticket);
       return  new ResponseEntity<>(updatedTicket,HttpStatus.OK);
    }
    //build Delete Ticket REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteTicket (@PathVariable("id")Long ticketId){
       ticketService.deleteTicket(ticketId);
       return  new ResponseEntity<>("Ticket has been deleted",HttpStatus.OK);
    }


}
