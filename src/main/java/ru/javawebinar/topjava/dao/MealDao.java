package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealDao {
    public Meal saveMeal(Meal meal);

    public void deleteMeal(int id);

    public Meal getMealById(int id);

    Collection<Meal> getAll();
}
