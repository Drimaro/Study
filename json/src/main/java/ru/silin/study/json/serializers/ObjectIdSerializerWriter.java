package ru.silin.study.json.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by konstantin.silin on 29.04.2016.
 */
public class ObjectIdSerializerWriter  extends BeanPropertyWriter {
    public ObjectIdSerializerWriter(BeanPropertyWriter w){
        super(w);
    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
        try {
            Object value = getValue(bean);
            Long id = (value == null) ? new Date().getTime() : (Long) value;
            gen.writeObjectField("_id", id);
        } catch (Exception e){
            super.serializeAsField(bean, gen, prov);
        }
    }

    private Object getValue(Object bean) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class<?> objClass = bean.getClass();
        Object value = new PropertyDescriptor("id", objClass).getReadMethod().invoke(bean);
        return value;
    }
}
