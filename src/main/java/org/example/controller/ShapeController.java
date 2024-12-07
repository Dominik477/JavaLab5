package org.example.controller;

import org.example.model.Shape;
import org.example.service.ShapeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @PostMapping
    public ResponseEntity<Shape> createShape(@RequestBody Shape shape) {
        Shape savedShape = shapeService.saveShape(shape);
        return ResponseEntity.ok(savedShape);
    }

    @GetMapping
    public ResponseEntity<List<Shape>> getAllShapes() {
        List<Shape> shapes = shapeService.findAllShapes();
        return ResponseEntity.ok(shapes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shape> getShapeById(@PathVariable Long id) {
        Shape shape = shapeService.findShapeById(id);
        return ResponseEntity.ok(shape);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShape(@PathVariable Long id) {
        shapeService.deleteShape(id);
        return ResponseEntity.noContent().build();
    }
}
