package com.vinaylogics.restfulwebservices.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse (
    LocalDateTime timestamp,
    String message,
    String detail
) {}
