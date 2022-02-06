package com.bilgeadam.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DoLoginRequestDto {
    @Email(message = "Lütfen geçerli bir email adresi giriniz.")
    @NotNull(message = "Email adresi boş geçilemez.")
    String username;

    @NotNull
    @Size(max = 32, min = 8, message = "Lütfen 8-32 arasında bir şifre giriniz.")
    String password;
}
