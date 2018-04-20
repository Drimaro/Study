package ru.silin.study.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.silin.study.json.entity.Entity;
import ru.silin.study.json.entity.SubEntity;
import ru.silin.study.json.serializers.BeanIdDeserializerModifier;
import ru.silin.study.json.serializers.BeanIdSerializerModifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by konstantin.silin on 29.04.2016.
 */
public class JsonMapperTest {
    private static final ObjectMapper mapper = new ObjectMapper();

    @BeforeClass
    public static void beforeClass() {
        SimpleModule module = new SimpleModule("testModule");
        module.setSerializerModifier(new BeanIdSerializerModifier());
        module.setDeserializerModifier(new BeanIdDeserializerModifier());
        mapper.registerModule(module);
    }

    @Test
    public void testJsonSerializer() throws JsonProcessingException {
        Entity entity = generateEntity();
        String strEntity = mapper.writeValueAsString(entity);
        System.out.println(strEntity);
        assertThat(strEntity, containsString("_id"));
    }

    @Test
    public void testJsonDeserialization() throws IOException {
        Entity entity = mapper.readValue(getJsonStream(), Entity.class);

        assertThat(entity.getId(), notNullValue());
        assertThat(entity.getSubEntities().size(), is(2));
        for(SubEntity subEntity : entity.getSubEntities()){
            assertThat(subEntity.getId(), notNullValue());
        }
    }

    public Entity generateEntity(){
        Entity entity = new Entity();
        entity.setName("test name");
        SubEntity subEntity = new SubEntity();
        subEntity.setName("subentiry test name");
        entity.setSubEntities(Collections.singletonList(subEntity));
        return entity;
    }

    public InputStream getJsonStream() throws IOException {
        return JsonMapperTest.class.getClassLoader().getResourceAsStream("entity.json");
    }

}
