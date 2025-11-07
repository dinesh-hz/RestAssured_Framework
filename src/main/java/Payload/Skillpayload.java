package Payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skillpayload implements Serializable {

    private String Name;
    private String level; //  Beginner, Intermediate, Expert
    private int experienceYears;


}
