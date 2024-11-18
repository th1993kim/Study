package core.config.jpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuditorAware implements AuditorAware<Long> {


    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.ofNullable(1L);
    }
}
