package com.univas.sd.service_b.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ShippingController {

    @GetMapping("/shipping/quote")
    public Map<String, Object> calculateShipping(
            @RequestParam String cep,
            @RequestParam double weightKg
    ) {

        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("CEP não pode ser vazio");
        }

        if (weightKg <= 0) {
            throw new IllegalArgumentException("weightKg deve ser maior que 0");
        }

        String region;
        double basePrice;

        if (cep.startsWith("30") || cep.startsWith("31")) {
            region = "MG";
            basePrice = 10.0;
        } else if (cep.matches("0[1-9].*")) {
            region = "SP";
            basePrice = 15.0;
        } else {
            region = "OUTROS";
            basePrice = 20.0;
        }

        int roundedWeight = (int) Math.ceil(weightKg);
        double additional = roundedWeight * 2.0;

        double total = basePrice + additional;

        Map<String, Object> response = new HashMap<>();
        response.put("cep", cep);
        response.put("weightKg", weightKg);
        response.put("region", region);
        response.put("total", total);

        return response;
    }
}
