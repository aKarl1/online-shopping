package com.hmall.trade.Listener;

import com.hmall.trade.domain.po.Order;
import com.hmall.trade.service.IOrderService;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayStatusListener {
    @Autowired
    private  IOrderService orderService;
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(name = "trade.pay.success.queue", durable = "true"),
        exchange = @Exchange(name = "pay.topic"),
        key = "pay.success"))
    public  void listenPaySuccess(Long orderId){
    // 1.查询订单
    Order old = orderService.getById(orderId);
    // 2.判断订单状态
    if (old == null || old.getStatus() != 1) {
        // 订单不存在或者订单状态不是1，放弃处理
        return;
    }
    orderService.markOrderPaySuccess(orderId);
    }
}
