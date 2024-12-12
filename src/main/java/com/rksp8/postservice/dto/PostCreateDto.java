package com.rksp8.postservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {

    @NotNull(message = "Content must not be null")
    @NotBlank(message = "Content must not be blank")
    private String content;
}
