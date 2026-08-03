package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.task
 * @Author: SUN
 * @Date: 2026/8/2 21:10
 * @Version: v1.0.0
 * @Description: 定时任务类，定时出来订单状态
 **/
@Component
@Slf4j
public class OrderTask {
	/**
	 * 处理超时订单
	 */
	@Autowired
	private OrderMapper orderMapper;
	@Scheduled(cron = "0 * * * * ?")
	public void processTimeoutOrder(){
		log.info("定时出来超时订单：{}", LocalDateTime.now());
		LocalDateTime time = LocalDateTime.now().plusMinutes(-15);

		List<Orders> ordersList = orderMapper.getByStatusAndOrderTimeLT(Orders.PENDING_PAYMENT, time);
		if(ordersList!=null&&ordersList.size()>0){
			for(Orders orders:ordersList){
				orders.setStatus(Orders.CANCELLED);
				orders.setCancelReason("订单超时，自动取消");
				orders.setCancelTime(LocalDateTime.now());
				orderMapper.update(orders);
			}
		}
	}

	/**
	 * 出来派送中的订单
	 */
	@Scheduled(cron = "0 0 1 * * ?")
	public void processDeliveryOrder(){
		log.info("定时处理处于派送中的订单，{}",LocalDateTime.now());

		LocalDateTime time = LocalDateTime.now().plusMinutes(-60);

		List<Orders> ordersList = orderMapper.getByStatusAndOrderTimeLT
				(Orders.DELIVERY_IN_PROGRESS, time);
		if(ordersList!=null&&ordersList.size()>0){
			for(Orders orders:ordersList){
				orders.setStatus(Orders.COMPLETED);
				orderMapper.update(orders);
			}
		}
	}
}
