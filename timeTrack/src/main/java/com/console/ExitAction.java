package com.console;

import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ExitAction implements UIAction{
    @Override
    public void execute() {
        System.out.println("Thank you for using our program");
        System.exit(0);
    }

    @Override
    public String getActionName() {
        return "Exit";
    }
}
