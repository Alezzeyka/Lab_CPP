package com.company;

import java.time.LocalDate;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        LabHandler LabHandler = new LabHandler();
        //LabHandler.Lab2(scan,r);
        LabHandler.Lab3();
    }
}
