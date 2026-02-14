package com.univas.sd.servicea.client;

public class ShippingResponse {

    private String cep;
    private double weightKg;
    private String region;
    private double total;
    private String source;

    public ShippingResponse() {}

    public ShippingResponse(String cep, double weightKg, String source, double total) {
        this.cep = cep;
        this.weightKg = weightKg;
        this.source = source;
        this.total = total;
    }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}
