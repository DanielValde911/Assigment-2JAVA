package com.example.assignment2;

import java.util.Map;

public class BitcoinValue {
    public TimeData time;
    public String disclaimer;
    public String chartName;
    public Map<String, CurrencyData> bpi;

    public BitcoinValue(){}
    // Getters and setters
    public String getDisclaimer(){return disclaimer;}

    public String getChartName(){return chartName;}

    public Map<String, CurrencyData> getBpi() {return bpi;}

    public void setTime(TimeData time){this.time = time;}

    public void setDisclaimer(String disclaimer){this.disclaimer = disclaimer;}

    public void setChartName(String chartName){this.chartName = chartName;}

    public void setBpi(Map<String, CurrencyData> bpi){this.bpi = bpi;}


}

