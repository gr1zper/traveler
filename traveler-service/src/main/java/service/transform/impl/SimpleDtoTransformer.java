package service.transform.impl;

import org.app.infra.util.Checks;
import org.app.infra.util.ReflectionUtil;
import org.app.model.entity.base.AbstractEntity;
import rest.dto.base.BaseDTO;
import service.transform.Transformer;

public class SimpleDtoTransformer implements Transformer {

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(
            final T entity, final Class<P> clz) {
        checkParams(entity, clz);

        P dto = ReflectionUtil.createInstance(clz);
        // Now just copy all the similar fields
        ReflectionUtil.copyFields(entity, dto,
                ReflectionUtil.findSimilarFields(entity.getClass(), clz));
        dto.transform(entity);

        return dto;
    }

    private void checkParams(final Object param, final Class<?> clz) {
        Checks.checkParameter(param != null, "Source transformation object is not initialized");
        Checks.checkParameter(clz != null,
                "No class is defined for transformation");
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(
            final P dto, final Class<T> clz) {
        checkParams(dto, clz);

        T entity = ReflectionUtil.createInstance(clz);

        ReflectionUtil.copyFields(dto, entity,
                ReflectionUtil.findSimilarFields(dto.getClass(), clz));
        dto.untransform(entity);

        return entity;
    }
}
