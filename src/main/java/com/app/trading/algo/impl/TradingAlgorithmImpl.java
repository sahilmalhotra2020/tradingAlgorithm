package com.app.trading.algo.impl;

import com.app.trading.algo.TradingAlgorithm;
import com.app.trading.entity.Price;
import com.app.trading.entity.Trade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TradingAlgorithmImpl implements TradingAlgorithm {

    private Map<String, List<Double>> productMap = new ConcurrentHashMap<>();
    private static int PRICE_CHANGE_LIMIT = 4;

    public TradingAlgorithmImpl(String[] productNames) {
         Arrays.stream(productNames).forEach(this::addToMap);
    }

    @Override
    public Trade buildTrade(Price price) {

        productMap.computeIfPresent(price.getProductName(), (k,v) -> {
            // Keep max 4 prices at a time and remove the oldest if it exceeds 4
            synchronized (productMap) {
                if (v.size() == PRICE_CHANGE_LIMIT) {
                    v.remove(0);
                }
                v.add(price.getNumericValue());
            }
            return v;
        });
        return computeTrade(price);
    }

    private Trade computeTrade(Price price) {

        List<Double> prices = productMap.get(price.getProductName());
        // check if oldest price is less than the average
        if (prices.size() == PRICE_CHANGE_LIMIT && prices.get(0) < prices.stream().mapToDouble(i -> i).average().getAsDouble()){
            return new Trade(price, 1000);
        }
        return null;
    }

    private void addToMap(String product){
        productMap.put(product, new ArrayList<>());
    }
}
