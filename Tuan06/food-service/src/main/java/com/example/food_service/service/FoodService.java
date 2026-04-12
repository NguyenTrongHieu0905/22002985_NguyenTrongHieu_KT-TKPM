package com.example.food_service.service;

import com.example.food_service.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private final List<Food> foods = new ArrayList<>();
    private Long idCounter = 1L;

    public FoodService() {
        // 🔥 seed sẵn
        foods.add(new Food(idCounter++, "Phở bò", 30000,
                "https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/kien-thuc/cach-nau-pho-bo-ha-noi/cach-nau-pho-bo-ha-noi-1.jpg"));

        foods.add(new Food(idCounter++, "Cơm tấm", 40000,
                "https://mms.img.susercontent.com/vn-11134513-7r98o-lytbg70qcy1911@resize_ss1242x600!@crop_w1242_h600_cT"));

        foods.add(new Food(idCounter++, "Bún bò", 35000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJmX-3YynOuNPCdbOZ5jAt-ijB1fHSWGwvxg"));

        foods.add(new Food(idCounter++, "Mì xào", 25000,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVLHLb1xBAgie7Wr0HL6azNj4soh9gJq3_HA"));
    }

    public List<Food> getAll() {
        return foods;
    }

    public Food add(Food food) {
        food.setId(idCounter++);
        foods.add(food);
        return food;
    }

    public Food update(Long id, Food updated) {
        for (Food f : foods) {
            if (f.getId().equals(id)) {
                f.setName(updated.getName());
                f.setPrice(updated.getPrice());
                return f;
            }
        }
        return null;
    }

    public void delete(Long id) {
        foods.removeIf(f -> f.getId().equals(id));
    }
}