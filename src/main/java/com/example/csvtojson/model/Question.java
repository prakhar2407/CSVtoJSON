package com.example.csvtojson.model;

// import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.format.annotation.DateTimeFormat;

@Document("Question")
public class Question {

    @Id
    private String id;

    private Integer techid;

    private Integer complexity;

    private String category;

    // private String qpath;

    private String stmt;

    private List<String> options = null;

    private Integer answer;

    private Long time;

    private String explanation;

    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    // private ZonedDateTime updatedtime;

    private Boolean applicable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTechid() {
        return techid;
    }

    public void setTechid(Integer techid) {
        this.techid = techid;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // public String getQpath() {
    // return qpath;
    // }

    // public void setQpath(String qpath) {
    // this.qpath = qpath;
    // }

    public String getStmt() {
        return stmt;
    }

    public void setStmt(String stmt) {
        this.stmt = stmt;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    // public ZonedDateTime getUpdatedtime() {
    // return updatedtime;
    // }

    // public void setUpdatedtime(ZonedDateTime updatedtime) {
    // this.updatedtime = updatedtime;
    // }

    public Boolean getApplicable() {
        return applicable;
    }

    public void setApplicable(Boolean applicable) {
        this.applicable = applicable;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", techid=" + techid + ", complexity=" + complexity + ", category=" + category
                + ", stmt=" + stmt + ", options=" + options + ", answer=" + answer + ", time=" + time + ", explanation="
                + explanation + ", applicable=" + applicable + "]\n";
    }
}
