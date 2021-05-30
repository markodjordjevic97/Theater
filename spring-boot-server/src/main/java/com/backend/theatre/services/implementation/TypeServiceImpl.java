package com.backend.theatre.services.implementation;

import com.backend.theatre.models.Type;
import com.backend.theatre.repository.TypeRepository;
import com.backend.theatre.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl  implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }
}
