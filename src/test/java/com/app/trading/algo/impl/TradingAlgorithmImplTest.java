package com.app.trading.algo.impl;

import com.app.trading.entity.Direction;
import com.app.trading.entity.Price;
import com.app.trading.entity.Trade;
import org.junit.Test;

import static org.junit.Assert.*;

public class TradingAlgorithmImplTest {

    @Test
    public void testBuildTrades() {

        String[] productNames = {"AA", "AB", "AC"};
        TradingAlgorithmImpl compTradingAlgo = new TradingAlgorithmImpl(productNames);

        Price priceA = new Price("AA", 179.9);
        Price priceB = new Price("AB", 180);
        Price priceC = new Price("AC", 7.60);

        assertEquals(null, compTradingAlgo.buildTrade(priceA));
        assertEquals(null, compTradingAlgo.buildTrade(priceB));
        assertEquals(null, compTradingAlgo.buildTrade(priceC));
    }

    @Test
    public void testUpwardTrendT1(){

        String[] productNames = {"AA", "AB", "AC"};
        TradingAlgorithmImpl compTradingAlgo = new TradingAlgorithmImpl(productNames);

        Price priceA = new Price("AA", 179.9);
        assertEquals(null, compTradingAlgo.buildTrade(priceA));

        Price priceB = new Price("AB", 180);
        assertEquals(null, compTradingAlgo.buildTrade(priceB));

        Price priceC = new Price("AC", 7.60);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 7.64);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 7.61);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 7.67);
        Trade trade = compTradingAlgo.buildTrade(priceC);

        assertEquals(7.67, trade.getPrice(), 4);
        assertEquals(1000, trade.getQuantity());
        assertEquals("AC", trade.getProductName());
        assertEquals(Direction.BUY, trade.getDirection());
    }

    @Test
    public void testUpwardTrendT2(){

        String[] productNames = {"AA", "AB", "AC"};
        TradingAlgorithmImpl compTradingAlgo = new TradingAlgorithmImpl(productNames);

        Price priceA = new Price("AA", 179.9);
        assertEquals(null, compTradingAlgo.buildTrade(priceA));

        Price priceB = new Price("AB", 180);
        assertEquals(null, compTradingAlgo.buildTrade(priceB));

        Price priceC = new Price("AC", 100.05);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 200.31);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 190.4);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 205.2);
        Trade trade = compTradingAlgo.buildTrade(priceC);

        assertEquals(205.2, trade.getPrice(), 4);
        assertEquals(1000, trade.getQuantity());
        assertEquals("AC", trade.getProductName());
        assertEquals(Direction.BUY, trade.getDirection());

        priceA = new Price("AA", 300.05);
        assertEquals(null, compTradingAlgo.buildTrade(priceA));

        priceA = new Price("AA", 200.1);
        assertEquals(null, compTradingAlgo.buildTrade(priceA));

        priceA = new Price("AA", 205.3);
        trade =  compTradingAlgo.buildTrade(priceA);

        assertEquals(205.3, trade.getPrice(), 4);
        assertEquals(1000, trade.getQuantity());
        assertEquals("AA", trade.getProductName());
        assertEquals(Direction.BUY, trade.getDirection());
    }


    @Test
    public void testDownWardTrend(){
        String[] productNames = {"AA", "AB", "AC"};
        TradingAlgorithmImpl compTradingAlgo = new TradingAlgorithmImpl(productNames);

        Price priceA = new Price("AA", 179.9);
        assertEquals(null, compTradingAlgo.buildTrade(priceA));

        Price priceB = new Price("AB", 180);
        assertEquals(null, compTradingAlgo.buildTrade(priceB));

        Price priceC = new Price("AC", 9);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 2);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 1);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));

        priceC = new Price("AC", 4);
        assertEquals(null, compTradingAlgo.buildTrade(priceC));
    }
}