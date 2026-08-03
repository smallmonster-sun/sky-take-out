package com.sky.service;

import com.sky.vo.TurnoverReportVO;

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
	 * @param begin
	 * @param end
	 * @return
	 */
	TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);
}
