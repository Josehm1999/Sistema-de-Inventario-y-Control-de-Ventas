package com.interfaces;

import java.util.ArrayList;

public interface OperacionesBD<T> {

    public abstract Boolean insert(T t, Object tipo);

    public abstract Boolean update(T t, Object tipo);

    public abstract Boolean delete(Object id);

    public abstract T selectById(Object id);

    public abstract ArrayList<T> selectAll();

    public abstract void closeConnection();
}
