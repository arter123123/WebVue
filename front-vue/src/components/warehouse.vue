warehouse
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
            getAllUrl: "warehouse/",
            dataUrl: "warehouse/",
            headers: [
                { name: "warehouseName", label: "Название склада" },
                { name: "typeWarehouse", label: "Тип скалада"},

            ],
            typeWarehouses: [],
        };
    },
    async created(){
			this.getItems();
			DataService.getData("typeWarehouse/").then(data => {
				this.typeWarehouses = data;
			});
		},
    methods: {
        getItems() {
            DataService.getData(this.getAllUrl).then(data => {
                this.items = data;
                this.warehouses = data;
            });
        },
        Save(data, md){
			   var s = '';
			   if(md == "create")
			       s = 'warehouse/';
			   return s + `?name=${data.warehouseName}&TypeWarehouseID=${data.typeWarehouseId}`;
		},
        getValSel(){
			var i;
			for(i = 0; i < this.typeWarehouses.length; i++)
				if(this.typeWarehouses[i].id == this.data.typeWarehouseId){
					this.data.typeWarehouseName = this.typeWarehouses[i].typeWarehouseName ;
					break;
			}
        },
    },
}
</script>

<template>
<h1> Список складов </h1>
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
              <label for="Name" class="form-label">Имя склада</label>
              <input type="text" class="form-control" id="Name" required v-model="data.warehouseName">
        </div>
        <div class="col-mb-3">
            <label for="typeWarehouse" class="form-label">Типы</label>
            <select class="form-select" id="typeWarehouse" required v-model="data.typeWarehouseId" @change="getValSel">
                <option selected disabled value="data.typeWarehouse">Ваш тип: {{ data.typeWarehouse }}</option>
                <option v-for="typeWarehouse in this.typeWarehouses" 
                        :value="typeWarehouse.id"
						:selected="data.typeWarehouseId && typeWarehouse.id === data.typeWarehouseId">
                        {{ typeWarehouse.typeWarehouseName }}
                </option>
            </select>
	    </div>
</Modal>
</template>

