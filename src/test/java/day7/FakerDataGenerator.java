package day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void fakerdata(){
        Faker data=new Faker();
        String name=data.name().fullName();
        String phone=data.phoneNumber().cellPhone();
        String email=data.internet().emailAddress();
        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);
    }
}
