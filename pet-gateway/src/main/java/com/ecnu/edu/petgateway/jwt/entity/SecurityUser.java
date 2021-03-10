package com.ecnu.edu.petgateway.jwt.entity;

import com.ecnu.edu.petapibase.user.domain.UserDO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {

    private UserDO userDO;

    private List<String> authorityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(authorityList)) {
            return null;
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String s : authorityList) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(s);
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userDO == null ? null : userDO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDO == null ? null : userDO.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
