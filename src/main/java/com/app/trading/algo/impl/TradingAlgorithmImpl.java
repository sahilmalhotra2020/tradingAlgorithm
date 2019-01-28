package com.app.trading.algo.impl;

import com.app.trading.algo.TradingAlgorithm;
import com.app.trading.entity.Price;
import com.app.trading.entity.Trade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TradingAlgorithmImpl implements TradingAlgorithm {

    private Map<String, List<Double>> productMap = new ConcurrentHashMap<>();
    private static int PRICE_CHANGE_LIMIT = 4;

    public TradingAlgorithmImpl(String[] productNames) {

        Arrays.stream(productNames).map(product -> productMap.put(product, new ArrayList<>()));
    }

    @Override
    public Trade buildTrade(Price price) {


        return null;
    }
}
