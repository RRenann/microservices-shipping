package com.univas.sd.servicea.api;

public class QuoteResponse {

    private String cep;
    private double weightKg;
    private String region;
    private double total;
    private String source;

    public QuoteResponse(String cep, double weightKg, String region, double total, String source) {
        this.cep = cep;
        this.weightKg = weightKg;
        this.region = region;
        this.total = total;
        this.source = source;
    }

    public String getCep() { return cep; }
    public double getWeightKg() { return weightKg; }
    public String getRegion() { return region; }
    public double getTotal() { return total; }
    public String getSource() { return source; }
}
