package cn.itcast.dubboxdemo.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "itcast传智播客";
    }
}
