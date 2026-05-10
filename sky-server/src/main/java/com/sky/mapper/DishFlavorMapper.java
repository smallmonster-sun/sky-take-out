package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.mapper
 * @Author: SUN
 * @Date: 2026/5/10 19:08
 * @Version: v1.0.0
 * @Description: 口味管理
 **/
@Mapper
public interface DishFlavorMapper {
	/**
	 * 批量插入
	 * @param flavors
	 */
	void insertBatch(List<DishFlavor> flavors);
}
