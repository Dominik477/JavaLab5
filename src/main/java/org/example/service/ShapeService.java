package org.example.service;

import org.example.model.Shape;
import org.example.repository.ShapeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Shape saveShape(Shape shape) {
        return shapeRepository.save(shape);
    }

    public List<Shape> findAllShapes() {
        return shapeRepository.findAll();
    }

    public Shape findShapeById(Long id) {
        return shapeRepository.findById(id).orElseThrow(() -> new RuntimeException("Shape not found with id: " + id));
    }

    public void deleteShape(Long id) {
        shapeRepository.deleteById(id);
    }
}
