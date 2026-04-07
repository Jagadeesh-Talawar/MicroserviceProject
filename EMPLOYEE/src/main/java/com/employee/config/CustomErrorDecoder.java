package com.employee.config;

import com.employee.exception.CustomException;
import com.employee.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try (InputStream is = response.body().asInputStream()) {
            ErrorResponse errorResponse = objectMapper.readValue(is, ErrorResponse.class);
            // convert int back to HttpStatus
            HttpStatus status = HttpStatus.valueOf(errorResponse.getStatus());
            return new CustomException(errorResponse.getMessage(), status);
        } catch (IOException e) {
            throw new CustomException("INTERNAL_SERVER_ERROR");
        }

    }
}