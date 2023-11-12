package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FakeDataSetter {

    private Faker faker = new Faker(new Locale("en-GB"));
    private String[] gender = {"Male", "Female", "Other"};
    private String[] hobby = {"Sports", "Reading", "Music"};
    private String[] subject = {"Maths", "Arts", "Chemistry", "History", "English"};
    private Map<String, String[]> stateAndCity = new HashMap<>();
    {   stateAndCity.put("NCR",            new String[] {"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh",  new String[] {"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana",        new String[] {"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan",      new String[] {"Jaipur", "Jaiselmer"});
    }

    public String firstName(){
        return faker.name().firstName();
    }

    public String lastName(){
        return faker.name().lastName();
    }

    public String email(){
        return faker.internet().emailAddress();
    }

    public String gender(){
        return faker.options().option(gender);
    }

    public String number(){
        return faker.number().digits(10);
    }


    public String subject(){
        return faker.options().option(subject);
    }

    public String hobby(){
        return faker.options().option(hobby);
    }

    public String currentAddress(){
        return faker.address().fullAddress();
    }

    public String state(){
         stateAndCity.toString();
         return faker.options().option(stateAndCity.keySet().toArray()).toString();
    }

    public String city(String state){
         return faker.options().option(stateAndCity.get(state));
    }
}