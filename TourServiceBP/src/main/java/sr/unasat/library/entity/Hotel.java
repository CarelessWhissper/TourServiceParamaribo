package sr.unasat.library.entity;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

    public Hotel(){

    }

    public Hotel(Tourist tourist,String name,int numberOfRooms, LocalDateTime reservationDetails, int numberOfStayingDays){
        this.tourist = tourist;
        this.HotelName = name;
        this.NumberOfRooms = numberOfRooms;
        this.ReservationDetails = reservationDetails;
        this.NumberOfStayingDays = numberOfStayingDays;

    }

}
