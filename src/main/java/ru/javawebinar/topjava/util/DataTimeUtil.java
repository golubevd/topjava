package ru.javawebinar.topjava.util;

import javafx.scene.input.DataFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTimeUtil {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-mm-dd  HH:mm");

    private DataTimeUtil() {
    }


    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}
