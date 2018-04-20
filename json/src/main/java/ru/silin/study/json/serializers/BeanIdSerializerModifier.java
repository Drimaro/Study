package ru.silin.study.json.serializers;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.List;

/**
 * Created by konstantin.silin on 29.04.2016.
 */
public class BeanIdSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for (int i = 0; i < beanProperties.size(); i++){
            BeanPropertyWriter writer = beanProperties.get(i);
            if (writer.getName().equals("id")){
                beanProperties.set(i, new ObjectIdSerializerWriter(writer));
            }
        }
        return beanProperties;
    }
}
