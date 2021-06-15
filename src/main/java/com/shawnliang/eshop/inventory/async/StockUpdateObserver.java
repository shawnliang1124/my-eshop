package com.shawnliang.eshop.inventory.async;

import java.util.Observable;
import java.util.Observer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Description : 更新库存观察者  .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/7
 */
@Slf4j
@Component
public class StockUpdateObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        GoodStockUpdateMessage updateMessage = (GoodStockUpdateMessage) arg;
        log.info("updateMessage is: {}", updateMessage.getMsgId());
    }
}
