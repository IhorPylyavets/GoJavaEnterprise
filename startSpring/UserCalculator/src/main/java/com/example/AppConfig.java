package com.example;

import com.example.operation.NumberDiv;
import com.example.operation.NumberMult;
import com.goit.springproject.arithmetic.Calculator;
import com.goit.springproject.operation.SimpleOperationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Bootstrap bootstrap(Calculator calculator) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setCalculator(calculator);

        return bootstrap;
    }

    @Bean
    @Scope("prototype")
    public SimpleOperationProvider simpleOperationProvider() {
        SimpleOperationProvider simpleOperationProvider = new SimpleOperationProvider();
        simpleOperationProvider.addOperation(new NumberDiv(2));
        simpleOperationProvider.addOperation(new NumberMult(2));

        return simpleOperationProvider;
    }

    @Bean
    public Calculator calculator() {
        return new Calculator(simpleOperationProvider());
    }

}
