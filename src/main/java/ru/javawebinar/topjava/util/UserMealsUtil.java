package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;


/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        System.out.println(getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 500));
//        .toLocalDate();
//        .toLocalTime();

    }

   /* public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> result = new ArrayList<>();

        mealList.stream()
                .filter(userMeal -> userMeal.getDateTime().getSecond() >= startTime.getSecond() && userMeal.getDateTime().getSecond() <= endTime.getSecond() && userMeal.getCalories() > caloriesPerDay)
                .forEach(userMeal -> result.add(new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), true)));


        return result;
    }*/

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        Map<LocalDate, Integer> sumColoriesByDate = new HashMap<>();
        for (UserMeal meal: mealList)
        {
            LocalDate tmpDate = meal.getDateTime().toLocalDate();
            int tpmSum = sumColoriesByDate.getOrDefault(tmpDate,0) + meal.getCalories();
            sumColoriesByDate.put(tmpDate,tpmSum);
        }

        List<UserMealWithExceed> result = new ArrayList<>();

        for (UserMeal userMeal: mealList)
        {
            if (TimeUtil.isBetween(userMeal.getDateTime().toLocalTime(),startTime,endTime)){
                result.add(new UserMealWithExceed(userMeal.getDateTime(),userMeal.getDescription(),userMeal.getCalories(),(caloriesPerDay > sumColoriesByDate.get(userMeal.getDateTime().toLocalDate()))));
            }
        }

        return result;
    }
}
