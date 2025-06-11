package com.example;


public class MessagePrinter {
    private final MessageService messageService;

    // Constructor Injection
    public MessagePrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void printMessage() {
        System.out.println(messageService.getMessage());
    }
}