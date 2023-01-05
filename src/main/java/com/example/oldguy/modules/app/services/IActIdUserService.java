package com.example.oldguy.modules.app.services;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oldguy.modules.app.dao.ActIdUser;

/**
 * <p>
 *  服务类
 * </p>
 * mybatisplus:
 *  ①“IActIdUserServiceImpl” => IActIdUserServiceImpl对象
 * ②“IActIdUserService” => MybatisMapperProxy对象
 * 需要控制@MapperScan的范围防止相同bean产生
 * @author generator
 * @since 2023-01-04
 */
public interface IActIdUserService extends IService<ActIdUser> {

}
