package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

/**
 * @Project: sky-take-out
 * @Package: com.sky.service
 * @Author: SUN
 * @Date: 2026/8/3 16:52
 * @Version: v1.0.0
 * @Description: 营业额统计
 **/
public interface ReportService {
	/**
	 * 统计指定时间区间内的营业额数据
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);

	/**
	 * 统计指定时间区间内的用户数据
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

	/**
	 * 指定时间内的订单数据
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

	/**
	 * 统计指定时间区间内的销量排名前10
	 *
	 * @param begin
	 * @param end
	 * @return
	 */
	SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
