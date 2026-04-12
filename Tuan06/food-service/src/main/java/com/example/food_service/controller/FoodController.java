package com.example.food_service.controller;

import com.example.food_service.model.Food;
import com.example.food_service.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "*")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAll() {
        return foodService.getAll();
    }

    @PostMapping
    public Food add(@RequestBody Food food) {
        return foodService.add(food);
    }

    @PutMapping("/{id}")
    public Food update(@PathVariable Long id, @RequestBody Food food) {
        return foodService.update(id, food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}