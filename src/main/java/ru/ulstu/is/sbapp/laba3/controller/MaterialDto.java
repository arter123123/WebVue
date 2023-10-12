package ru.ulstu.is.sbapp.laba3.controller;

import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class MaterialDto {
    private final long id;
    @NotBlank
    private final String materialname;

    public MaterialDto(Material material) {
        this.id = material.getId();
        this.materialname = material.getMaterialName();
    }

    public long getId() {
        return id;
    }

    public String getMaterialName() {
        return materialname;
    }
}
