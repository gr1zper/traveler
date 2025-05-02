package service.transform;

import org.app.model.entity.base.AbstractEntity;
import rest.dto.base.BaseDTO;

/**
 * Represents transformation engine to convert business entities into DTO objects
 *
 * @author azubkov
 */
public interface Transformer {

    /**
     * Converts specified entity into DTO object
     *
     * @param entity
     * @param clz
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz);

    /**
     * Converts specified DTO object into business entity
     *
     * @param dto
     * @param clz
     * @return
     */
    <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clz);
}
