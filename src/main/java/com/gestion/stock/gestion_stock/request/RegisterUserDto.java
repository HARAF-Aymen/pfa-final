package com.gestion.stock.gestion_stock.request;

import com.gestion.stock.gestion_stock.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    private String email;
    private String password;
    private String nom;
    private Role role;

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", role=" + role +
                '}';
    }
}