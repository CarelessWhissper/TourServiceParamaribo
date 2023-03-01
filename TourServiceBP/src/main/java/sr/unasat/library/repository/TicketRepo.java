package sr.unasat.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import sr.unasat.library.entity.Ticket;

@Repository
@EnableJpaRepositories
public interface TicketRepo extends JpaRepository<Ticket,Long> {


}
