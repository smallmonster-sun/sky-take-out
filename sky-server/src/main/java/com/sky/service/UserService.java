package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @Project: sky-take-out
 * @Package: com.sky.service
 * @Author: SUN
 * @Date: 2026/7/21 16:03
 * @Version: v1.0.0
 * @Description:
 **/
public interface UserService {
		/**
		 * 微信登录
		 * @param userLoginDTO
		 * @return
		 */
		User wxLogin(UserLoginDTO userLoginDTO);
}

