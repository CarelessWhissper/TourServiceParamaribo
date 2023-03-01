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

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @Column
    private String HotelName;

    @Column
    private int NumberOfRooms;

    @Column
    private LocalDateTime ReservationDetails;

    @Column
    private int NumberOfStayingDays;


}
