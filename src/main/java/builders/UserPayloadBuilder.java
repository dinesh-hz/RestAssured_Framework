package builders;

import Payload.Addrespayload;
import Payload.Skillpayload;
import Payload.Userpayload;

import java.util.List;

public class UserPayloadBuilder {

    // Default payload for common use
    public static Userpayload createDefaultUser() {
        return Userpayload.builder()
                .firstname("Dinesh")
                .lastename("Murugan")
                .Emailid("dineshmeij@gmail.com")
                .Age(28)
                .addres(Addrespayload.builder()
                        .city("Nagercoil")
                        .landmark("Bus Stop")
                        .district("Kanyakumari")
                        .build())
                .skils(List.of(
                        Skillpayload.builder().Name("Java").level("Advanced").experienceYears(5).build(),
                        Skillpayload.builder().Name("API Testing").level("Intermediate").experienceYears(3).build()
                ))
                .build();
    }

    // Build from test data (Cucumber DataTable)
    public static Userpayload createUserFromData(String firstname, String lastname, String email, int age,
                                                 String city, String landmark, String district) {
        return Userpayload.builder()
                .firstname(firstname)
                .lastename(lastname)
                .Emailid(email)
                .Age(age)
                .addres(Addrespayload.builder()
                        .city(city)
                        .landmark(landmark)
                        .district(district)
                        .build())
                .skils(List.of(
                        Skillpayload.builder().Name("Manual Testing").level("Intermediate").experienceYears(2).build()
                ))
                .build();
    }
}
