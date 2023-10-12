<script>
import axios from 'axios';
import CatalogMixins from '../mixins/CatalogMixins.js';
import Material from '../models/Material.js';
import DataService from '../services/DataService';
import DataTable from './DataTable.vue';

export default {
    mixins: [
        CatalogMixins
    ],
    data() {
        return {
            getAllUrl: "warehousesmaterials/",
            dataUrl: "warehousesmaterials/",
            headers: [
                { name: "amount", label: "количество" },
                { name: "warehouse", label: "Склад"},
                { name: "material", label: "Материалы"}

            ],
            warehouses: [],
            materials: [],
        };
    },
    async created(){
			this.getItems();
			DataService.getData("warehouse/").then(data => {
				this.warehouses = data;
			});
            this.getItems();
            DataService.getData("material/").then(data =>{
                this.materials = data;
            });
		},
    methods: {
        getItems() {
            DataService.getData(this.getAllUrl).then(data => {
                this.items = data;
                this.warehousesmaterialss = data;
            });
        },
        Save(data, md){
			   var s = '';
			   if(md == "create")
			       s = 'warehousesmaterials/';
			   return s + `?amount=${data.amount}&WarehouseID=${data.warehouseId}&MaterialID=${data.materialId}`;
		},
        getValSel(){
			var i;
			for(i = 0; i < this.warehouses.length; i++)
				if(this.warehouses[i].id == this.data.warehouseId){
					this.data.warehouseName = this.warehouses[i].warehouseName ;
					break;
			}
        },
        getValSelMat(){
			var i;
			for(i = 0; i < this.materials.length; i++)
				if(this.materials[i].id == this.data.materialId){
					this.data.materialName = this.materials[i].materialName ;
					break;
			}
        },
    },
}
</script>

<template>
<h1> Список склад материала </h1>
<DataTable
        :headers="this.headers"
        :items="this.items"
        :selectedItems="this.selectedItems"
        @dblclick="showEditModalDblClick">
</DataTable>
<ToolBar
     @add="showAddModal"
     @edit="showEditModal"
     @remove="removeSelectedItems">
</ToolBar>
<Modal
        :header="this.modal.header"
        :confirm="this.modal.confirm"
        v-model:visible="this.modalShow"
        @done="saveItem">
		<div class="col-mb-3">
              <label for="amount" class="form-label">Количество материала</label>
              <input type="number" class="form-control" id="amount" required v-model="data.amount">
        </div>
        <div class="col-mb-3">
            <label for="warehouse" class="form-label">Склад</label>
            <select class="form-select" id="warehouse" required v-model="data.warehouseId" @change="getValSel">
                <option selected disabled value="">Укажите склад...</option>
                <option v-for="warehouse in this.warehouses" 
                        :value="warehouse.id"
						:selected="data.warehouseId && warehouse.id === data.warehouseId">
                        {{ warehouse.warehouseName }}
                </option>
            </select>
	    </div>
        <div class="col-mb-3">
            <label for="material" class="form-label">Материал</label>
            <select class="form-select" id="material" required v-model="data.materialId" @change="getValSelMat">
                <option selected disabled value="">Укажите материал...</option>
                <option v-for="material in this.materials" 
                        :value="material.id"
						:selected="data.materialId && material.id === data.materialId">
                        {{ material.materialName }}
                </option>
            </select>
	    </div>
</Modal>
</template>

