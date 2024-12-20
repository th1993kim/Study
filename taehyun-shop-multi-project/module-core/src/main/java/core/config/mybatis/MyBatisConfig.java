package core.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(
        basePackages = "core", // core 패키지와 하위 패키지 스캔
        annotationClass = org.apache.ibatis.annotations.Mapper.class // Mapper 인터페이스만 스캔
)
@Configuration
public class MyBatisConfig {
}
