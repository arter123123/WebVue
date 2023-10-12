package ru.ulstu.is.sbapp.laba3.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;
import ru.ulstu.is.sbapp.laba3.model.WarehousesMaterials;

import javax.validation.constraints.NotBlank;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class WarehousesMaterialsDto {
    private final long id;
    @NotBlank
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private final Warehouse warehouse;
    @NotBlank
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private final Material material;
    @NotBlank
    private final Integer amount;
    public WarehousesMaterialsDto(WarehousesMaterials warehousesMaterials) {
        this.id = warehousesMaterials.getId();
        this.warehouse = warehousesMaterials.getWarehouse();
        this.material = warehousesMaterials.getMaterial();
        this.amount = warehousesMaterials.getAmount();
    }
    public Long getId() {
        return id;
    }
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Material getMaterial() {
        return material;
    }
    public Integer getAmount(){return amount;}
}
