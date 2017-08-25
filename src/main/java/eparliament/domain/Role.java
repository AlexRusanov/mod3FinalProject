package eparliament.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by alexandrrusanov on 25/8/17.
 */
public enum Role implements GrantedAuthority {
    USER,
    MODER,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
