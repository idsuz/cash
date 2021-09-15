package uz.mybux.cash.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String API_ENDPOINT = "/swagger-ui/**";
    private static final String API_RECOURCES_ENDPOINT = "/webjars/**";
    private static final String API_SWAGGER_RECOURCES_ENDPOINT = "/swagger-resources/**";
    private static final String API_DOCS_ENDPOINT = "/v2/api/**";
    private static final String API_DOWNLOAD_ENDPOINT = "/api/v2/upload/download/**";
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("resource_id").stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
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
                .antMatchers("/sw").permitAll()
                .antMatchers(API_DOWNLOAD_ENDPOINT).permitAll()
                .antMatchers("/chatwithbots/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}
