package com.spring_barber_shop.exception;

public class ScheduleInUseException extends RuntimeException {

    public ScheduleInUseException(String message) {
        super(message);
    }

}
