package com.example.assignment2;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.net.ssl.HttpsURLConnection;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //TODO add stylesheet
        //scene.getStylesheets().add("com.example.assignment2/style.css");
        stage.setTitle("Bitcoin price!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {

        Filler filler = new Filler();

        URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int response = connection.getResponseCode();

        if (response == HttpsURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            String jsonString = String.valueOf(sb);
            System.out.println("JSON: " + jsonString);

            //Decrypt jsonString to java using gson
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();

            BitcoinValue bitcoinValue = gson.fromJson(jsonString, BitcoinValue.class);

            //TODO fix timeData returning null
            TimeData timeData = new TimeData();
            System.out.println("Updated: " + timeData.getUpdated());

            Map<String, CurrencyData> currencyDataMap = bitcoinValue.getBpi();
            for (Map.Entry<String, CurrencyData> entry : currencyDataMap.entrySet()) {
                CurrencyData currencyData = entry.getValue();
                System.out.println("Currency: " + currencyData.getCode());
                System.out.println("Rate: " + currencyData.getRate());

            }
            CurrencyData usdCurrencyData = bitcoinValue.getBpi().get("USD");
            filler.setBitcoinValueUSD("USD price: " + usdCurrencyData.getRate());
            System.out.println(filler.getBitcoinValueUSD());

            CurrencyData gbpCurrencyData = bitcoinValue.getBpi().get("GBP");
            filler.setBitcoinValueGBP("GBP price: " + gbpCurrencyData.getRate());
            System.out.println(filler.getBitcoinValueGBP());

            CurrencyData eurCurrencyData = bitcoinValue.getBpi().get("EUR");
            filler.setBitcoinValueEUR("EUR price: " + eurCurrencyData.getRate());
            System.out.println(filler.getBitcoinValueEUR());
        }
        //launch FX
        launch();
    }
}