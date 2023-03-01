package sr.unasat.library.entity;

import java.util.Date;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Setter
@Getter
@ToString
public class Tourist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fName")
    private String FullName;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "locationOfOrigin")
    private String LocationOfOrigin;


    public Tourist(){

    }

    public Tourist(String fullName,Date dateOfBirth, String locationOfOrigin){

        this.FullName = fullName;
        this.dateOfBirth =dateOfBirth;
        this.LocationOfOrigin = locationOfOrigin;
    }


}
