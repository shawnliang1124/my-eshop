package com.shawnliang.eshop.inventory.async;

import java.util.Observable;
import lombok.Data;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/6/7
 */
@Data
public class StockUpdateObservable extends Observable {

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 构造函数
     * @param messageId 消息id
     */
    public StockUpdateObservable(String messageId) {
        this.messageId = messageId;
    }

    public void setResult(Boolean result) {
        GoodStockUpdateMessage updateMessage = new GoodStockUpdateMessage();

        this.setChanged();
        this.notifyObservers(updateMessage);
    }

}
