package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.service
 * @Author: SUN
 * @Date: 2026/7/25 09:57
 * @Version: v1.0.0
 * @Description: 购物车
 **/
public interface ShoppingCartService {
	/**
	 * 添加购物车
	 *
	 * @param shoppingCartDTO
	 */
	void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

	/**
	 * 查看购物车
	 *
	 * @return
	 */
	List<ShoppingCart> showShoppingCart();

	/**
	 * 清空购物车
	 */
	void cleanShoppingCart();

	/**
	 * 删除购物车中一个商品
	 *
	 * @param shoppingCartDTO
	 */
	void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
