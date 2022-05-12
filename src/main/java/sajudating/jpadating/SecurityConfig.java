package sajudating.jpadating;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import sajudating.jpadating.security.JwtAuthFilter;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.addFilterBefore(new HeadersManipulator(), BasicAuthenticationFilter.class);
//        http.addFilterBefore(new RequestLoggingFilter(), BasicAuthenticationFilter.class);
//        http.addFilterBefore(new TokenValidatorFilter(), BasicAuthenticationFilter.class);
        //http 시큐리티 빌더
        http.cors()
                .and()
                .csrf()
                .disable()
                .httpBasic()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/v1/api/**" , "**/login/**").permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterAfter(
                jwtAuthFilter, BasicAuthenticationFilter.class);
    }

}
