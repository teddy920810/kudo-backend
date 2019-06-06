package com.kudo.transformer;

import com.google.common.collect.Lists;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseTransformer<Dto, Entity> {

    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    default List<Dto> toDtoCollection(Collection<Entity> entities) {
        if (entities == null || entities.size() == 0) {
            return Lists.newArrayList();
        }
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<Entity> toEntityCollection(Collection<Dto> dtos) {
        if (dtos == null || dtos.size() == 0) {
            return Lists.newArrayList();
        }
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}

