package sajudating.jpadating.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CorsFilter;
import sajudating.jpadating.security.JwtAuthFilter;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    private final JwtAuthFilter jwtAuthFilter;

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
                .antMatchers(HttpMethod.POST,"/v1/api/members/**")
//                .antMatchers(HttpMethod.POST,"/members/**").permitAll()
//                .antMatchers(HttpMethod.PUT,"/members/**").permitAll()
//                .antMatchers(HttpMethod.DELETE,"/members/**").permitAl()
                .permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterAfter(
//                jwtAuthFilter, BasicAuthenticationFilter.class);
                jwtAuthFilter, CorsFilter.class);

    }

}
