package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Profile implements Serializable{
    private static final long serialVersionUID = -2715394097317982575L;
    @Id
    String id;
    long authid;
    String firstname;
    String lastname;
    String email;
    String birthdate;
    String country;
    String city;
    String gender;
    String about;
    List<Interest> interest;
    Education education;
    Work work;

    @Document
    @Data
    public static class Education implements Serializable {
        private static final long serialVersionUID = 7762343345810487479L;
        String name;
        int from;
        int to;
        String about;
    }

    @Document
    @Data
    public static class Work implements Serializable{
        private static final long serialVersionUID = -6393032873812031159L;
        String company;
        String designation;
        int from;
        int to;
        String town;
        String description;
    }
}
