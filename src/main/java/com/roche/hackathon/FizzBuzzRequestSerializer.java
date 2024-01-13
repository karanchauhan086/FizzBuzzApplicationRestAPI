package com.roche.hackathon;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class FizzBuzzRequestSerializer extends JsonSerializer<FizzBuzzRequest> {
    @Override
    public void serialize(FizzBuzzRequest value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Implement serialization logic here
        // For example, serialize each property individually using gen.writeObjectField or gen.writeStringField
    }
}
