package edu.utez.mx.examU2.dto;

import org.jetbrains.annotations.NotNull;

public class CategoryDto {
    private Long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 150)
    private String name;
    private Boolean status;


    public Category getCategory() {
        return new Category(
                getId(),
                getName(),
                getStatus(),
                getSubcategories());
    }
}
