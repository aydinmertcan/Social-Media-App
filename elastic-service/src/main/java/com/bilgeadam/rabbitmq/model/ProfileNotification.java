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
    private static final long serialVersionUID = 7844068117629537366L;
    String profileId;
    String firstname;
    String lastname;
    String email;
    String city;
    String country;
}
