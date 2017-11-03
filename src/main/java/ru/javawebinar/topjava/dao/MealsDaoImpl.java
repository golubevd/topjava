package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealsDaoImpl implements MealDao {

    private Map<Integer, Meal> repo = new ConcurrentHashMap<>();
    private AtomicInteger concurrent = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(this::saveMeal);
    }


    @Override
    public Meal saveMeal(Meal meal) {
        if (meal.isNew()) {
            meal.setId(concurrent.incrementAndGet());
        }
        repo.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public void deleteMeal(int id) {
        repo.remove(id);

    }

    @Override
    public Meal getMealById(int id) {

        return repo.get(id);
    }

    @Override
    public Collection<Meal> getAll() {

        return repo.values();
    }
}
