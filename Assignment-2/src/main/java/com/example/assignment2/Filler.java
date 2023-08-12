package com.example.assignment2;

public class Filler {
    private static String bitcoinValueUSD;
    private static String bitcoinValueGBP;
    private static String bitcoinValueEUR;

    public String getBitcoinValueGBP() {
        return bitcoinValueGBP;
    }

    public void setBitcoinValueGBP(String bitcoinValueGBP) {
        Filler.bitcoinValueGBP = bitcoinValueGBP;
    }

    public String getBitcoinValueEUR() {
        return bitcoinValueEUR;
    }

    public void setBitcoinValueEUR(String bitcoinValueEUR) {
        Filler.bitcoinValueEUR = bitcoinValueEUR;
    }

    public String getBitcoinValueUSD() {
        return bitcoinValueUSD;
    }

    public void setBitcoinValueUSD(String bitcoinValueUSD) {
        this.bitcoinValueUSD = bitcoinValueUSD;
    }
}
