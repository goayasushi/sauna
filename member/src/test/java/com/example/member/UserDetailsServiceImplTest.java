package com.example.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.example.member.domain.model.Account;
import com.example.member.domain.repository.AccountRepository;
import com.example.member.domain.service.UserDetailsServiceImpl;

@ContextConfiguration(classes = TestConfig.class)
public class UserDetailsServiceImplTest {
	@Mock
    private AccountRepository accountRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsernameWhenUserExists() {
        Account mockAccount = createMockAccount("user", "password", "USER");
        when(accountRepository.findByAccountname("user")).thenReturn(mockAccount);

        UserDetails userDetails = userDetailsService.loadUserByUsername("user");

        assertEquals("user", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    void loadUserByUsernameWhenUserDoesNotExist() {
        when(accountRepository.findByAccountname("unknown")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("unknown");
        });
    }

    @Test
    void saveNewAccount() {
        Account account = createMockAccount("newUser", "password", "ROLE_USER");
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        userDetailsService.save(account);

        verify(accountRepository).save(any(Account.class));
        verify(passwordEncoder).encode("password");
    }

    private Account createMockAccount(String username, String password, String role) {
        Account account = new Account();
        account.setAccountname(username);
        account.setPassword(password);
        account.setRole(role);
        return account;
    }
}
