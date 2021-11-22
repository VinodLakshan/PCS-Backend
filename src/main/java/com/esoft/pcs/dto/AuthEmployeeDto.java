package com.esoft.pcs.dto;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthEmployeeDto implements UserDetails {

    private final Employee employee;

    public AuthEmployeeDto(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee(){
        return employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole().getRoleName()));
        return authorities;
    }

    public Integer getId() {
        return employee.getId();
    }

    public String getName() {
        return employee.getName();
    }

    public Branch getBranch() {
        return employee.getBranch();
    }

    public Role getRole() { return employee.getRole(); }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getUserName();
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
