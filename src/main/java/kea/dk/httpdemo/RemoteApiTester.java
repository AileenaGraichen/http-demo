/*
package kea.dk.httpdemo;

import kea.dk.httpdemo.dto.Age;
import kea.dk.httpdemo.dto.Gender;
import kea.dk.httpdemo.dto.MyCombinedResponse;
import kea.dk.httpdemo.dto.Nationality;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RemoteApiTester implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        getGendersBlocking();
        getGendersNonBlocking();
    }


    List<String> names = Arrays.asList("lars", "peter", "sanne", "kim", "david", "maja");


    public void getGendersBlocking() {
        long start = System.currentTimeMillis();
        List<Gender> genders = names.stream().map(name -> getGender(name).block()).toList();
        long end = System.currentTimeMillis();
        System.out.println("Time for six external requests, BLOCKING: "+ (end-start));
    }

    public void getGendersNonBlocking() {
        long start = System.currentTimeMillis();
        var genders = names.stream().map(name -> getGender(name)).toList();
        Flux<Gender> flux = Flux.merge(Flux.concat(genders));
        List<Gender> res = flux.collectList().block();
        long end = System.currentTimeMillis();
        System.out.println("Time for six external requests, NON-BLOCKING: "+ (end-start));
    }

}
*/

