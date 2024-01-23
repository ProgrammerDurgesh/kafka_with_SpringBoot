package durgeshkafka.configuration;

import durgeshkafka.entity.User;
import durgeshkafka.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
@Service
public class MyUserDetails implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public MyUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userRepository.findByEmail(username);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(null));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private @NotNull Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        if (user != null) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("");
            authorities.add(simpleGrantedAuthority);
        }
        return authorities;
    }
}
