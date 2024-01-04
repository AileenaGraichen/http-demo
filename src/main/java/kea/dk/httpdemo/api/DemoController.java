package kea.dk.httpdemo.api;

import kea.dk.httpdemo.dto.MyCombinedResponse;
import kea.dk.httpdemo.service.DemoService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    private final int SLEEP_TIME = 1000*3;

    @GetMapping(value = "/random-string-slow")
    public String slowEndpoint() throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @GetMapping("/{name}")
    public MyCombinedResponse getNameData(@PathVariable String name){
        return service.fetchNameDetails(name).block();
    }
}
