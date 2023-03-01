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
public class Hotel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tourist_id",referencedColumnName = "id")
    private Tourist tourist;

    private String HotelName;

    private int NumberOfRooms;

    private LocalDateTime ReservationDetails;

    private int NumberOfStayingDays;


}
