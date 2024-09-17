package utils;

import com.github.javafaker.Faker;

public class JavaFaker {

    Faker faker = new Faker();

    public String getFirstName() {
        //Generating the first name
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        //Generating last name
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String getEmail() {
        //Generating email Id
        String email = faker.internet().emailAddress();
        return email;
    }

    public String getPassword() {
        //Generating password
        String pwd = faker.internet().password();
        return pwd;
    }

    public String getPhone() {
        //Generating password
        String phone = faker.phoneNumber().cellPhone();
        return phone;
    }
}
