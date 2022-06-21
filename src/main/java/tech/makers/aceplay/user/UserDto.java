package tech.makers.aceplay.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDto implements UserDetails {

        private Long id;
      
        private String username;
      
        private String password;
      
        protected UserDto() {}
      
        public UserDto(String username, String password) {
          this.username = username;
          this.password = password;
        }
      
        public Long getId() {
          return id;
        }
      
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
          Set<GrantedAuthority> authorities = new HashSet<>();
          authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
          return authorities;
        }
      
        @Override
        public String getPassword() {
          return password;
        }
      
        public String getUsername() {
          return username;
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
      
        @Override
        public String toString() {
          return String.format(
              "User[id=%d username='%s' password=HIDDEN]", id, username);
        }    
}
