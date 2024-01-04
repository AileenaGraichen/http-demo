package kea.dk.httpdemo.service;

import kea.dk.httpdemo.dto.Age;
import kea.dk.httpdemo.dto.Gender;
import kea.dk.httpdemo.dto.MyCombinedResponse;
import kea.dk.httpdemo.dto.Nationality;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DemoService {
    public Mono<MyCombinedResponse> fetchNameDetails(String name){
        Mono<Gender> gender = getGender(name);
        Mono<Age> age = getAge(name);
        Mono<Nationality> nationality = getNationality(name);
        return Mono.zip(gender, age, nationality)
                .map(tuple -> new MyCombinedResponse(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

    Mono<Gender> getGender(String name) {
        WebClient client = WebClient.create();
        Mono<Gender> gender = client.get()
                .uri("https://api.genderize.io?name="+name)
                .retrieve()
                .bodyToMono(Gender.class);
        return gender;
    }

    Mono<Age> getAge(String name){
        WebClient client = WebClient.create();
        Mono<Age> age = client.get()
                .uri("https://api.agify.io?name="+name)
                .retrieve()
                .bodyToMono(Age.class);
        return age;
    }

    Mono<Nationality> getNationality(String name){
        WebClient client = WebClient.create();
        Mono<Nationality> nationality = client.get()
                .uri("https://api.nationalize.io?name="+name)
                .retrieve()
                .bodyToMono(Nationality.class);
        return nationality;
    }
}
