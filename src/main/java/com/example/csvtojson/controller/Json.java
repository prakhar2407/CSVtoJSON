package com.example.csvtojson.controller;

import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;
// import java.util.Iterator;
import java.util.List;
// import java.util.ListIterator;
// import java.util.Scanner;

import com.example.csvtojson.model.Question;

public class Json {
    public static void main(String[] args) throws IOException {
        csvToJson();
    }

    public static void csvToJson() throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/com/example/csvtojson/controller/question.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        System.out.println();
        System.out.println(records.size());
        System.out.println();
        List<Question> questionList = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            List<String> record = records.get(i);
            Question question = new Question();
            question.setTechid(Integer.parseInt(record.get(0)));
            question.setComplexity(Integer.parseInt(record.get(1)));
            question.setCategory(record.get(2));
            question.setStmt(record.get(3));
            List<String> options = new ArrayList<>();
            Collections.addAll(options, record.get(4), record.get(5), record.get(6), record.get(7));
            question.setOptions(options);
            question.setAnswer(Integer.parseInt(record.get(8)));
            question.setTime(Long.parseLong(record.get(9)));
            question.setExplanation(record.get(10));
            questionList.add(question);
        }
        System.out.println(questionList);
    }
}
