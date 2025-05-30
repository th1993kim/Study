package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "api",
        "core"
})
public class ShopSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopSpringBootApplication.class, args);
    }
}
