package kea.dk.httpdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class MyCombinedResponse {
    String name;
    String gender;
    double genderProbability;
    int age;
    int ageCount;
    String country;
    double countryProbability;

    public MyCombinedResponse(Gender gender, Age age, Nationality nationality) {
        this.name = gender.getName();
        this.gender = gender.getGender();
        this.genderProbability = gender.getProbability();
        this.age = age.getAge();
        this.ageCount = age.getCount();
        findMostLikelyCountry(nationality);
    }

    private void findMostLikelyCountry(Nationality nationality){
        String country_id = "";
        double maxProbability = 0;
        ArrayList<Country> countryList = nationality.getCountry();
        for(Country country : countryList){
            if(country.getProbability() > maxProbability){
                maxProbability = country.getProbability();
                country_id = country.getCountry_id();
            }
        }
        this.country = country_id;
        this.countryProbability = maxProbability;
    }



}
