package ru.silin.study.json.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by konstantin.silin on 29.04.2016.
 */
@Data
public class Entity {
    private Long id;
    private String name;

    private List<SubEntity> subEntities;
}
