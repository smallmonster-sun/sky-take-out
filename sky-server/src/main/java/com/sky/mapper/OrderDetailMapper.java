package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.mapper
 * @Author: SUN
 * @Date: 2026/8/1 15:05
 * @Version: v1.0.0
 * @Description:
 **/
@Mapper
public interface OrderDetailMapper {
	/**
	 * 批量插入订单明细数据
	 * @param orderDetailList
	 */
	void insertBatch(List<OrderDetail> orderDetailList);

	/**
	 * 根据订单id查询订单明细
	 * @param orderId
	 * @return
	 */
	@Select("select * from order_detail where order_id = #{orderId}")
	List<OrderDetail> getByOrderId(Long orderId);
}
