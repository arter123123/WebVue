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
            getAllUrl: "material/",
            dataUrl: "material/",
            headers: [
                { name: "materialName", label: "Название компонента" },
            ],
        };
    },
    methods: {
        getItems() {
            DataService.getData(this.getAllUrl).then(data => {
                this.items = data;
            });
        },
        Save(data, md){
			   var s = '';
			   if(md == "create")
			       s = 'material/';
			   return s + `?Name=${data.materialName}`;
		}
    },
}
</script>

<template>
<h1> Список материала </h1>
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
              <label for="Name" class="form-label">Имя материала</label>
              <input type="text" class="form-control" id="Name" required v-model="data.materialName">
         </div>
</Modal>
</template>

