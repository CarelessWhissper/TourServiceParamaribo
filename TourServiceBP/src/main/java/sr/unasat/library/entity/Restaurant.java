package sr.unasat.library.entity;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String RestaurantName;

    private int NumberOfPeople;

    private LocalDateTime ReservationDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tourist_id",referencedColumnName = "id")
    private Tourist tourist;
}
