package com.example.psktask1.Utils.Decorators;

import com.example.psktask1.Interfaces.ITeacherService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TeacherConfig {

    @Bean
    @Primary
    @ConditionalOnProperty(name = "teacher.decorator.enabled", havingValue = "true")
    public ITeacherService decoratedTeacherService(ITeacherService base) {
        return new MockTeacherDecorator(base);
    }
}
