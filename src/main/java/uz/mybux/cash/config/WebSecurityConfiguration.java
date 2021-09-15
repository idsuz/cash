package uz.mybux.cash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final String API_ENDPOINT = "/sw/**";
    private static final String API_RECOURCES_ENDPOINT = "/webjars/**";
    private static final String API_SWAGGER_RECOURCES_ENDPOINT = "/swagger-resources/**";
    private static final String API_DOCS_ENDPOINT = "/v2/api/**";
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(API_ENDPOINT).permitAll()
                .antMatchers(API_RECOURCES_ENDPOINT).permitAll()
                .antMatchers(API_SWAGGER_RECOURCES_ENDPOINT).permitAll()
                .antMatchers(API_DOCS_ENDPOINT).permitAll()

                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
