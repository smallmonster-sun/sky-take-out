package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.mapper
 * @Author: SUN
 * @Date: 2026/5/16 17:17
 * @Version: v1.0.0
 * @Description:
 **/
@Mapper
public interface SetmealDishMapper {
	/**
	 * 根据菜品id查询对应的套餐id
	 *
	 * @param dishIds
	 * @return
	 */
	List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

	/**
	 * 批量保持套餐和菜品的关联关系
	 *
	 * @param setmealDishes
	 */
	void insertBatch(List<SetmealDish> setmealDishes);

	/**
	 * 根据套餐id删除套餐和菜品的关联关系
	 *
	 * @param setmealId
	 */
	@Delete("delete from setmeal_dish where setmeal_id = #{setmealId} ")
	void deleteBySetmealId(Long setmealId);

	/**
	 * 批量删除
	 *
	 * @param setmealIds
	 */
	void deleteBySetmealIds(List<Long> setmealIds);

	/**
	 * 根据id查询套餐关系
	 *
	 * @param id
	 * @return
	 */
	@Select("select * from setmeal_dish where setmeal_id = #{id}")
	List<SetmealDish> getBySetmealId(Long id);
}
