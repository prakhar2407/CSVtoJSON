package com.example.csvtojson.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.csvtojson.model.Question;
import com.example.csvtojson.repository.QuestionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.nio.charset.StandardCharsets;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.Objects;
// import java.util.stream.Collectors;

// import java.util.List;

@RestController
public class QuestionController {
    // public static String csvToJson(List<String> csv) {

    // // remove empty lines
    // // this will affect permanently the list.
    // // be careful if you want to use this list after executing this method
    // csv.removeIf(e -> e.trim().isEmpty());

    // // csv is empty or have declared only columns
    // if (csv.size() <= 1) {
    // return "[]";
    // }

    // // get first line = columns names
    // String[] columns = csv.get(0).split(",");

    // // get all rows
    // StringBuilder json = new StringBuilder("[\n");
    // csv.subList(1, csv.size()) // substring without first row(columns)
    // .stream()
    // .map(e -> e.split(","))
    // .filter(e -> e.length == columns.length) // values size should match with
    // columns size
    // .forEach(row -> {

    // json.append("\t{\n");

    // for (int i = 0; i < columns.length; i++) {
    // json.append("\t\t\"")
    // .append(columns[i])
    // .append("\" : \"")
    // .append(row[i])
    // .append("\",\n"); // comma-1
    // }

    // // replace comma-1 with \n
    // json.replace(json.lastIndexOf(","), json.length(), "\n");
    // json.append("\t},"); // comma-2
    // });

    // // remove comma-2
    // json.replace(json.lastIndexOf(","), json.length(), "");
    // json.append("\n]");
    // return json.toString();
    // }

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/addQuestions")
    public List<Question> addNewQuestion() throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/com/example/csvtojson/controller/question.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
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
        try {
            for (Question question : questionList) {
                questionRepository.save(question);
            }
        } catch (Exception e) {
            LOG.error("Error while saving user.");
            e.printStackTrace();
        }
        return questionList;
    }
}
