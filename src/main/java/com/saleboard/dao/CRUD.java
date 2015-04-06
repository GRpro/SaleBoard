package com.saleboard.dao;

import java.util.List;

public interface CRUD<E> {
    
    public long create(E object);
    public E get(long id);
    public List<E> getAll();
    public void update(E object);
    public void delete(E object);
    
}
