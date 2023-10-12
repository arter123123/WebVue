package ru.ulstu.is.sbapp.laba3.controller;
import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class WarehouseDto {
    private final long id;
    @NotBlank
    private final String warehousename;
    @NotBlank
    private final TypeWarehouse typeWarehouse;

    public WarehouseDto(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.warehousename = warehouse.getWarehouseName();
        this.typeWarehouse = warehouse.getTypeWarehouse();
    }

    public long getId() {
        return id;
    }
    public String getWarehouseName(){
        return warehousename;
    }
    public TypeWarehouse getTypeWarehouse(){
        return typeWarehouse;
    }
}
