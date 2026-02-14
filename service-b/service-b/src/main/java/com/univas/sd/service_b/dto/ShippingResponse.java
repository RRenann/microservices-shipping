package com.univas.sd.service_b.dto;

public class ShippingResponse {

    private String cep;
    private double weightKg;
    private String region;
    private double total;

    public ShippingResponse(String cep, double weightKg, String region, double total) {
        this.cep = cep;
        this.weightKg = weightKg;
        this.region = region;
        this.total = total;
    }

    public String getCep() { return cep; }
    public double getWeightKg() { return weightKg; }
    public String getRegion() { return region; }
    public double getTotal() { return total; }
}
