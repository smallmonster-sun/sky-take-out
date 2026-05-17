package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

	/**
	 * 根据菜品id删除对应的口味数据
	 */
	@Delete("delete from dish_flavor where dish_id = #{dishId}")
	void deleteByDishId(Long id);

	/**
	 *根据菜品id批量删除对应的口味数据
	 * @param ids
	 */
	void deleteByDishIds(List<Long> ids);

	/**
	 * 根据菜品id查询对应的口味数据
	 * @param dishId
	 * @return
	 */
	@Select("select * from dish_flavor where dish_id = #{dishId}")
	List<DishFlavor> getByDishId(Long dishId);
}
