package ru.ulstu.is.sbapp.laba3.controller;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;

import javax.validation.constraints.NotBlank;

public class TypeWarehouseDto {
    private final long id;
    @NotBlank
    private final String typewarehousename;

    public TypeWarehouseDto(TypeWarehouse typeWarehouse) {
        this.id = typeWarehouse.getId();
        this.typewarehousename = typeWarehouse.getTypeWarehouseName();
    }

    public long getId() {
        return id;
    }

    public String getTypeWarehouseName() {
        return typewarehousename;
    }
}
