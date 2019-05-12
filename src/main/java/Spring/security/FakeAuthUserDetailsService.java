package Spring.security;

import Spring.repos.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FakeAuthUserDetailsService implements
        AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    private UserRepo userRepo;

    public FakeAuthUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public final UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token)
            throws AuthenticationException {
        Spring.domain.User user = userRepo.findById(1).get();
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(user.getLogin(), "N/A", true, true, true, true, authorities);
    }

}
