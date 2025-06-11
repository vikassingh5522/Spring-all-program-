package example;

import org.springframework.beans.factory.annotation.Autowired;

public class MessagePrinter {
    @Autowired
    private MessageService messageService;

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}