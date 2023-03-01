package sr.unasat.library.entity;

import java.util.Date;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Tourist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String FullName;

    private Date dateOfBirth;

    private String LocationOfOrigin;

    @OneToMany(mappedBy = "tourist")
    private Ticket ticket;

    @OneToMany(mappedBy = "hotel")
    private Hotel hotel;
}
