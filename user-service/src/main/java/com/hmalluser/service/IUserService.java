package com.hmalluser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmalluser.domain.po.User;
import com.hmalluser.domain.vo.UserLoginVO;
import com.hmalluser.domain.dto.LoginFormDTO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2023-05-05
 */
public interface IUserService extends IService<User> {

    UserLoginVO login(LoginFormDTO loginFormDTO);

    void deductMoney(String pw, Integer totalFee);
}
