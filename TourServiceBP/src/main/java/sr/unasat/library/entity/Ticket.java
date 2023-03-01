package sr.unasat.library.entity;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Entity
@Setter
@Getter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String DepartingLocation;

    private Date DepartDate;

    private Date ReturnDate;

    @ManyToOne
    @JoinColumn(name = "tourist_id",nullable = false)
    private Tourist tourist;
}
