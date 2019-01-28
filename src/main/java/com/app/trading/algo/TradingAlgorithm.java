package com.app.trading.algo;

import com.app.trading.entity.Price;
import com.app.trading.entity.Trade;

public interface TradingAlgorithm {

    /**
     * Builds a trade to be executed based on the supplied prices.
     *
     * @param price data
     * @return trade to execute
     */

    Trade buildTrade(Price price);

}
