package com.shawnliang.eshop.inventory.async;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/15
 */
@Component
public class StockUpdateResultManagerImpl implements StockUpdateResultManager {

    /**
     * 商品库存更新结果map
     */
    private Map<String, StockUpdateObservable> observableMap =
            new ConcurrentHashMap<String, StockUpdateObservable>();


    /**
     * 商品库存更新结果观察者
     */
    @Autowired
    private StockUpdateObserver observer;

    @Override
    public void observe(String messageId) {
        StockUpdateObservable observable = new StockUpdateObservable(messageId);
        observable.addObserver(observer);
        observableMap.put(messageId, observable);
    }

    @Override
    public void inform(String messageId, Boolean result) {
        StockUpdateObservable observable = observableMap.get(messageId);
        observable.setResult(result);
        observableMap.remove(messageId);
    }

    @Override
    public StockUpdateObservable getObservable(String messageId) {
        return observableMap.get(messageId);
    }
}
