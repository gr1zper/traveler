package rest.dto.base;

import org.app.model.entity.base.AbstractEntity;

public abstract class BaseDTO<T extends AbstractEntity> {

    private int id;

    public void transform(T t) {
        id = t.getId();
    }

    public T untransform(T t) {
        t.setId(id);
        return t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
