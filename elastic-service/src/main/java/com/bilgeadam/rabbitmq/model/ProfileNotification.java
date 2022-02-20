package com.bilgeadam.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProfileNotification implements Serializable {
    private static final long serialVersionUID = 5609274314700163728L;
    String profileid;
    String firstname;
    String lastname;
    String email;
    String city;
    String country;

}
