package com.univas.sd.servicea.api;

import com.univas.sd.servicea.client.ServiceBClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class CallBController {

    private final ServiceBClient client;

    public CallBController(ServiceBClient client) {
        this.client = client;
    }

    @GetMapping("/quote")
    public Mono<QuoteResponse> getQuote(
            @RequestParam String cep,
            @RequestParam double weightKg) {

        return client.getQuote(cep, weightKg)
                .map(response -> new QuoteResponse(
                        response.getCep(),
                        response.getWeightKg(),
                        response.getRegion(),
                        response.getTotal(),
                        "service-b"
                ))
                .timeout(Duration.ofSeconds(2))
                .onErrorResume(ex -> Mono.just(
                        new QuoteResponse(
                                cep,
                                weightKg,
                                null,
                                25.0,
                                "fallback"
                        )
                ));
    }
}