package com.univas.sd.servicea.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ServiceBClient {

    private final WebClient webClient;

    public ServiceBClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ShippingResponse> getQuote(String cep, double weightKg) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/shipping/quote")
                        .queryParam("cep", cep)
                        .queryParam("weightKg", weightKg)
                        .build())
                .retrieve()
                .bodyToMono(ShippingResponse.class);
    }
}
