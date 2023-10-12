package ru.ulstu.is.sbapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.ulstu.is.sbapp.laba3.model.Material;
import ru.ulstu.is.sbapp.laba3.model.TypeWarehouse;
import ru.ulstu.is.sbapp.laba3.model.Warehouse;
import ru.ulstu.is.sbapp.laba3.service.MaterialService;
import ru.ulstu.is.sbapp.laba3.service.TypeWarehouseService;
import ru.ulstu.is.sbapp.laba3.service.WarehouseService;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class SbappApplicationTests {
    /*
    /*
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private TypeWarehouseService typeWarehouseService;
    //@Autowired
    //private FindByNameService findService;
    /*
    @Test
    void testTypeWarehouseCreate(){
        typeWarehouseService.deleteAllTypeWarehouses();
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        Assertions.assertNotNull(typeWarehouse.getId());
    }

     */
    /*
    @Test
    void testMaterialCreate(){
        materialService.deleteAllMaterials();
        final Material material = materialService.addMaterial("Material");
        Assertions.assertNotNull(material.getId());
    }
    /*
    @Test
    void testWarehouseCreate() throws IOException {
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material material1 = materialService.addMaterial("Material1");
        final Material material2 = materialService.addMaterial("Material2");
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final Warehouse warehouse1= warehouseService.addWarehouse("Warehouse1", typeWarehouse.getId());
        final Warehouse warehouse2= warehouseService.addWarehouse("Warehouse2", typeWarehouse.getId());
        warehouse1.addMaterial(material1);
        warehouse2.addMaterial(material1);
        warehouse2.addMaterial(material2);
        Assertions.assertNotNull(warehouse1.getId());
        Assertions.assertNotNull(warehouse2.getId());
    }
    @Test
    void ReadWarehouse() throws IOException {
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material material1 = materialService.addMaterial("Material");
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final Warehouse warehouse2= warehouseService.addWarehouse("Warehouse", typeWarehouse.getId());
        warehouse2.addMaterial(material1);
        final Warehouse findWarehouse = warehouseService.findWarehouse(warehouse2.getId());
        Assertions.assertEquals(warehouse2, findWarehouse);
    }
    @Test
    void ReadWarehouseTrue() throws IOException {
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material material1 = materialService.addMaterial("Material1");
        final Material material2 = materialService.addMaterial("Material2");
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        Warehouse warehouse2 = warehouseService.addWarehouse("Warehouse", typeWarehouse.getId());
        warehouse2 = warehouseService.addMaterial(warehouse2.getId(),material1.getId());
        warehouse2 = warehouseService.addMaterial(warehouse2.getId(),material2.getId());
        final Warehouse findWarehouse = warehouseService.findWarehouse(warehouse2.getId());
        Assertions.assertEquals(warehouse2, findWarehouse);
    }
    @Test
    void ReadWarehouseTypeWarehouse() throws IOException {
        warehouseService.deleteAllWarehouses();
        typeWarehouseService.deleteAllTypeWarehouses();
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        Warehouse warehouse2 = warehouseService.addWarehouse("Warehouse2", typeWarehouse.getId());
        Warehouse warehouse1 = warehouseService.addWarehouse("Warehouse1", typeWarehouse.getId());
        Assertions.assertEquals(typeWarehouse.getWarehouses().size(), 2);
    }
    @Test
    void ReadWarehouseNameTypeWarehouse() throws IOException {
        warehouseService.deleteAllWarehouses();
        typeWarehouseService.deleteAllTypeWarehouses();
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        Warehouse warehouse2 = warehouseService.addWarehouse("Warehouse2", typeWarehouse.getId());
        Warehouse warehouse1 = warehouseService.addWarehouse("Warehouse1", typeWarehouse.getId());
        int count = 0;
        List<Warehouse> listwar= typeWarehouse.getWarehouses();
        for (int i = 0; i < listwar.size(); i++){
            if(listwar.get(i) == warehouse1 || listwar.get(i) == warehouse2){
                count++;
            }
        }
        final Warehouse findWarehouse = warehouseService.findWarehouse(warehouse2.getId());
        if(count == 2) {
            Assertions.assertEquals(count, 2);
        }
        else {
            Assertions.assertEquals(typeWarehouse.getWarehouses().size(), 0);
        }
    }
    @Test
    void ReadTypeWarehouse(){
        typeWarehouseService.deleteAllTypeWarehouses();
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final Warehouse warehouse = warehouseService.addWarehouse("Warehouse", typeWarehouse.getId());
        final TypeWarehouse findTypeWarehouse = typeWarehouseService.findTypeWarehouse(typeWarehouse.getId());
        Assertions.assertEquals(typeWarehouse, findTypeWarehouse);
    }

     */
    /*
    @Test
    void ReadMaterial(){
        materialService.deleteAllMaterials();
        final Material material = materialService.addMaterial("Material");
        final Material findMaterial = materialService.findMaterial(material.getId());
        Assertions.assertEquals(material, findMaterial);
    }
    /*
    @Test
    void testWarehouseCheck() throws IOException {
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material material1 = materialService.addMaterial("Material1");
        final Material material2 = materialService.addMaterial("Material2");
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final Warehouse warehouse2 = warehouseService.addWarehouse("Warehouse", typeWarehouse.getId());
        warehouse2.addMaterial(material1);
        warehouse2.addMaterial(material2);
        Assertions.assertEquals(warehouse2.getMaterials().size(),2);
    }
    @Test
    void testWarehousePreviewCheck() throws IOException {
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material material1 = materialService.addMaterial("Material");
        final Material material2 = materialService.addMaterial("Material1");
        final TypeWarehouse typeWarehouse = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final Warehouse warehouse2 = warehouseService.addWarehouse("Warehouse", typeWarehouse.getId());
        warehouse2.addMaterial(material1);
        warehouse2.addMaterial(material2);
        Warehouse v = warehouseService.findWarehouse(warehouse2.getId());
    }
    @Test
    void testTypeWarehouseReadNotFound() {
        typeWarehouseService.deleteAllTypeWarehouses();
        Assertions.assertThrows(EntityNotFoundException.class, () -> typeWarehouseService.findTypeWarehouse(-1L));
    }
     */
    /*
    @Test
    void testMaterialReadNotFound() {
        materialService.deleteAllMaterials();
        Assertions.assertThrows(EntityNotFoundException.class, () -> materialService.findMaterial(-1L));
    }
    /*
    @Test
    void testWarehouseReadNotFound() {
        warehouseService.deleteAllWarehouses();
        Assertions.assertThrows(EntityNotFoundException.class, () -> warehouseService.findWarehouse(-1L));
    }
    @Test
    void testTypeWarehouseCount(){
        typeWarehouseService.deleteAllTypeWarehouses();
        final TypeWarehouse typeWarehouse1 = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final TypeWarehouse typeWarehouse2 = typeWarehouseService.addTypeWarehouse("TypeWarehouse1");
        final List<TypeWarehouse> typeWarehouses = typeWarehouseService.findAllTypeWarehouses();
        Assertions.assertEquals(typeWarehouses.size(),2);
    }

     */
    /*
    @Test
    void testMaterialCount(){
        materialService.deleteAllMaterials();
        final Material cat1 = materialService.addMaterial("Shorts");
        final Material ca2 = materialService.addMaterial("Comedy");
        final List<Material> categories = materialService.findAllMaterials();
        Assertions.assertEquals(categories.size(),2);
    }
    /*
    @Test
    void testWarehouseCount() throws IOException {
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material cat1 = materialService.addMaterial("Material");
        final TypeWarehouse typeWarehouse2 = typeWarehouseService.addTypeWarehouse("TypeWarehouse");
        final Warehouse warehouse1 = warehouseService.addWarehouse("Warehouse", typeWarehouse2.getId());
        final Warehouse warehouse2 = warehouseService.addWarehouse("Warehouse1", typeWarehouse2.getId());
        warehouse1.addMaterial(cat1);
        warehouse2.addMaterial(cat1);
        final List<Warehouse> warehouses = warehouseService.findAllWarehouses();
        Assertions.assertEquals(warehouses.size(),2);
    }

     */
    /*
    @Test
    void testDop() {
        String nameToTest = "a";

        // создаем данные для тестирования
        warehouseService.deleteAllWarehouses();
        materialService.deleteAllMaterials();
        typeWarehouseService.deleteAllTypeWarehouses();
        final Material material1 = materialService.addMaterial(nameToTest, "genre");
        final Warehouse warehouse1 = warehouseService.addWarehouse(nameToTest);
        final TypeWarehouse typeWarehouse1 = typeWarehouseService.addTypeWarehouse(nameToTest, 3.29);
        warehouse1.addMaterial(material1);
        material1.addWarehouse(warehouse1);
        warehouse1.addTypeWarehouse(typeWarehouse1);

        Map<String, List<Object>> resultMap = findService.GetResult(nameToTest);

        List<Object> materialsList = resultMap.get("materials");
        assertEquals(1, materialsList.size());
        Object materialResult = materialsList.get(0);
        assertEquals(nameToTest, ((Material) materialResult).getMaterialName());

        List<Object> warehousesList = resultMap.get("warehouses");
        assertEquals(1, warehousesList.size());
        Object warehouseResult = warehousesList.get(0);
        assertEquals(nameToTest, ((Warehouse) warehouseResult).getWarehouseName());

        List<Object> typeWarehousesList = resultMap.get("typeWarehouses");
        assertEquals(1, typeWarehousesList.size());
        Object typeWarehouseResult = typeWarehousesList.get(0);
        assertEquals(nameToTest, ((TypeWarehouse) typeWarehouseResult).getTypeWarehouseName());
    }
    */
}
