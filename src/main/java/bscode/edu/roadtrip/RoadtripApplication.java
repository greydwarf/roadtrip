package bscode.edu.roadtrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

@SpringBootApplication
public class RoadtripApplication {
    /*
        @EventListener
        public void handleContextRefreshed(ContextRefreshedEvent event) {
            ConfigurableEnvironment env = (ConfigurableEnvironment) event.getApplicationContext().getEnvironment();
            env.getPropertySources()
                    .stream()
                    .filter(ps -> ps instanceof MapPropertySource)
                    .map(ps -> ((MapPropertySource) ps).getSource().keySet())
                    .flatMap(Collection::stream)
                    .distinct()
                    .sorted()
                    .forEach(key -> System.out.println(key + "=" + env.getProperty(key)));
        }
    */

    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return request -> {
			OAuth2User user = delegate.loadUser(request);
			return user;
		};
    }

    public static void main(String[] args) {
        SpringApplication.run(RoadtripApplication.class, args);
    }
}
