package com.coffeproject.Services;

import com.coffeproject.Models.SpringCoffeeUserDetails;
import com.coffeproject.Models.User;
import com.coffeproject.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringCoffeeUserDetailsService implements UserDetailsService {
    public final UserRepository usersDao;

    public SpringCoffeeUserDetailsService(UserRepository usersDao) {
        this.usersDao = usersDao;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User details not found for user:" + username);
        } else {
            return new SpringCoffeeUserDetails(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
        }
    }
}
