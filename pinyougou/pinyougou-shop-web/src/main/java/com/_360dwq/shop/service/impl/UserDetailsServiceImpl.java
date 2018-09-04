package com._360dwq.shop.service.impl;

import com._360dwq.pojo.TbSeller;
import com._360dwq.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dw_Qin
 * @Date 2017/09/01 21:06
 * @Email 569806951@qq.com
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //构建角色列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        //根据登录名到数据库查询密码
        TbSeller seller = sellerService.findOne(username);
        //已审核通过的商家才能登录
        if(seller!=null && "1".equals(seller.getStatus())){
            return new User(username,seller.getPassword(),authorities);
        }
        return null;
    }

    public void setSellerService(SellerService sellerService){
        this.sellerService = sellerService;
    }
}
