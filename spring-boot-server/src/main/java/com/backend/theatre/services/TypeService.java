package com.backend.theatre.services;

import com.backend.theatre.models.Type;

import java.util.List;

public interface TypeService {

    public Type saveType(Type type);

    public List<Type> getTypes();
}
