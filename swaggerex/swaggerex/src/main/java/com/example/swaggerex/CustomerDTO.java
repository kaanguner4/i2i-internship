package com.example.swaggerex;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDTO {

    @Schema(description = "Unique ID of the customer", example = "1")
    private Long id;

    @NotBlank
    @Schema(description = "Full name of the customer", example = "John Doe")
    private String name;

    @Email
    @Schema(description = "Email address", example = "john.doe@example.com")
    private String email;
}
