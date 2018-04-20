package ru.silin.study.json.serializers;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by konstantin.silin on 29.04.2016.
 */
public class BeanIdDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public List<BeanPropertyDefinition> updateProperties(DeserializationConfig config, BeanDescription beanDesc, List<BeanPropertyDefinition> propDefs) {
        ListIterator<BeanPropertyDefinition> iterator = propDefs.listIterator();
        while(iterator.hasNext()){
            BeanPropertyDefinition beanProp = iterator.next();
            if (beanProp.getName().equals("id")){
                iterator.remove();
                iterator.add(beanProp.withSimpleName("_id"));
            }
        }
        return propDefs;
    }

    @Override
    public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, BeanDescription beanDesc, BeanDeserializerBuilder builder) {
        Iterator<SettableBeanProperty> beanPropertyIterator = builder.getProperties();
        while (beanPropertyIterator.hasNext()){
            SettableBeanProperty settableBeanProperty = beanPropertyIterator.next();
            if(settableBeanProperty.getName().equals("_id")){
                builder.addOrReplaceProperty(settableBeanProperty.withValueDeserializer(new ObjectIdPropertyDeserializer()), true);
            }
        }
        return builder;
    }
}