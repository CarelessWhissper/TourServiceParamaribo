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

    @Column
    private String RestaurantName;

    @Column
    private int NumberOfPeople;

    private LocalDateTime ReservationDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    public Restaurant(){

    }
}
