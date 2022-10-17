package com.example.demo.Repositorio;

import org.springframework.stereotype.Repository;
import com.example.demo.Modelo.Cloud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Interface.CloudInterface;

@Repository

public class CloudRepository {

    @Autowired
    private CloudInterface extencionesCrud;

    public List<Cloud> getAll() {
        return (List<Cloud>) extencionesCrud.findAll();
    }

    public Optional<Cloud> getCloud(int id) {
        return extencionesCrud.findById(id);
    }

    public Cloud save(Cloud cloud) {
        return extencionesCrud.save(cloud);
    }
    
    public void delete(Cloud cloud){
        extencionesCrud.delete(cloud);
    }
}
