package com.example.demo.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Modelo.Cloud;
import com.example.demo.Repositorio.CloudRepository;

@Service

public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll() {
        return cloudRepository.getAll();
    }

    public Optional<Cloud> getCloud(int id) {
        return cloudRepository.getCloud(id);
    }

    public Cloud save(Cloud cloud) {
        if (cloud.getId() == null) {
            return cloudRepository.save(cloud);
        } else {
            Optional<Cloud> cloud1 = cloudRepository.getCloud(cloud.getId());
            if (cloud1.isEmpty()) {
                return cloudRepository.save(cloud);
            } else {
                return cloud;
            }
        }
    }

    public Cloud update(Cloud cloud) {
        if (cloud.getId() != null) {
            Optional<Cloud> e = cloudRepository.getCloud(cloud.getId());
            if (!e.isEmpty()) {
                if (cloud.getName() != null) {
                    e.get().setName(cloud.getName());
                }
                if (cloud.getBrand() != null) {
                    e.get().setBrand(cloud.getBrand());
                }
                if (cloud.getYear() != null) {
                    e.get().setYear(cloud.getYear());
                }
                if (cloud.getDescription() != null) {
                    e.get().setDescription(cloud.getDescription());
                }
                if (cloud.getCategory() != null) {
                    e.get().setCategory(cloud.getCategory());
                }
                cloudRepository.save(e.get());
                return e.get();
            } else {
                return cloud;
            }
        } else {
            return cloud;
        }
    }

    public boolean deleteCloud(int id) {
        Boolean d = getCloud(id).map(cloud -> {
            cloudRepository.delete(cloud);
            return true;
        }).orElse(false);
        return d;
    }
}
