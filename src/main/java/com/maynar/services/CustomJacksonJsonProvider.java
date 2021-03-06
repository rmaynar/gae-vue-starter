package com.maynar.services;

import java.io.IOException;

import javax.ws.rs.ext.Provider;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;





/**
 * Generic JSON provider with some custom processing
 * @author Alejandro Aranda
 * 
 */
@Provider
public class CustomJacksonJsonProvider extends JacksonJsonProvider {

    public CustomJacksonJsonProvider() {
        super();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);        
        SimpleModule module = new SimpleModule();
        module.addSerializer(DateTime.class, new JsonSerializer<DateTime>() {
            @Override
            public void serialize(DateTime dt, JsonGenerator generator,
                    SerializerProvider provider) throws IOException,
                    JsonProcessingException {
                if (dt != null) {
                    generator.writeString(ISODateTimeFormat
                            .dateHourMinuteSecond().print(dt));
                } else {
                    generator.writeNull();
                }
            }
        });
        mapper.registerModule(module);
        setMapper(mapper);
    }
}
