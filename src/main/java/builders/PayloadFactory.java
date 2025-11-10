package builders;

import Payload.Addrespayload;
import Payload.Skillpayload;
import Payload.Userpayload;

import java.util.List;

public class PayloadFactory {

    // Default payload for common use
    public static Userpayload createDefaultUser() {
        return Userpayload.builder()
                .firstName("userjdj")
                .lastName("Murugan")
                .emailid("dineshmeij@gmail.com")
                .age(28)
                .addres(Addrespayload.builder()
                        .city("Nagercoil")
                        .landmark("Bus Stop")
                        .district("Kanyakumari")
                        .build())
                .skils(List.of(
                        Skillpayload.builder()
                                .name("Java")
                                .level("Advanced")
                                .experienceYears(5)
                                .build()
                ))
                .build();
    }

    // Build from test data (Cucumber DataTable and External file)
    public static Userpayload createUserFromData(String firstname, String lastname, String email, int age,
                                                 String city, String landmark, String district,
                                                 String skillname, String skillevel, int experienceYears) {
        return Userpayload.builder()
                .firstName(firstname)
                .lastName(lastname)
                .emailid(email)
                .age(age)
                .addres(Addrespayload.builder()
                        .city(city)
                        .landmark(landmark)
                        .district(district)
                        .build())
                .skils(List.of(
                        Skillpayload.builder()
                                .name(skillname)
                                .level(skillevel)
                                .experienceYears(experienceYears)
                                .build()

                ))
                .build();
    }
}
