// package com.example.csvtojson.controller;

// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.List;
// import java.util.stream.Collectors;

// import com.example.csvtojson.model.Question;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.apache.tomcat.util.json.JSONParser;
// import org.bson.json.JsonObject;

// public class Foo {

//     static List<Question> questions;

//     Foo(List<Question> questions) {
//         questions = this.questions;
//     }

//     public void setQuestions(List<Question> questions) {
//         this.questions = questions;
//     }

//     public List<Question> getQuestions() {
//         return questions;
//     }

//     public static void main(String[] args) throws Exception {
//         // JSONParser parser = new JSONParser();
//         // JsonObject json1 = (JsonObject) parser.parse();

//         List<String> csvRows = null;
//         // String filename="";
//         // Path pathToFile = Paths.get(filename);
//         // System.out.println(pathToFile.toAbsolutePath());
//         try (var reader = Files.lines(Paths.get("src/main/java/com/example/csvtojson/controller/question.csv"))) {
//             csvRows = reader.collect(Collectors.toList());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         if (csvRows != null) {
//             String json = csvToJson(csvRows);
//             List<Question> questionList = (List<Question>) new ObjectMapper().readValue(json, Question.class);
//             // questions = questionList;
//             System.out.println(questionList);
//             // System.out.println(json);
//         }
//     }

//     public static String csvToJson(List<String> csv) {
//         // remove empty lines
//         // this will affect permanently the list.
//         // be careful if you want to use this list after executing this method
//         csv.removeIf(e -> e.trim().isEmpty());
//         // csv is empty or have declared only columns
//         if (csv.size() <= 1) {
//             return "[]";
//         }
//         // get first line = columns names
//         String[] columns = csv.get(0).split(",");
//         // get all rows
//         StringBuilder json = new StringBuilder("[\n");
//         csv.subList(1, csv.size()) // substring without first row(columns)
//                 .stream()
//                 .map(e -> e.split(","))
//                 .filter(e -> e.length == columns.length) // values size should match with columns size
//                 .forEach(row -> {
//                     json.append("\t{\n");
//                     for (int i = 0; i < columns.length; i++) {
//                         // if (i == 4 || i == 5 || i == 6 || i == 7) {
//                         // json.append()
//                         // }
//                         // else {
//                         json.append("\t\t\"")
//                                 .append(columns[i])
//                                 .append("\" : \"")
//                                 .append(row[i])
//                                 .append("\",\n"); // comma-1
//                         // }
//                     }
//                     // replace comma-1 with \n
//                     json.replace(json.lastIndexOf(","), json.length(), "\n");
//                     json.append("\t},"); // comma-2
//                 });
//         // remove comma-2
//         json.replace(json.lastIndexOf(","), json.length(), "");
//         json.append("\n]");
//         return json.toString();
//     }

// }
