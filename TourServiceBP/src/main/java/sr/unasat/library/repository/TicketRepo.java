package sr.unasat.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sr.unasat.library.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {


}
