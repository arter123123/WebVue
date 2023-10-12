import ToolBar from '../components/ToolBar.vue';
import DataTable from '../components/DataTable.vue';
import Modal from '../components/Modal.vue';
import DataService from '../services/DataService';

const CatalogMixin = {
    components: {
        ToolBar, Modal, DataTable
    },
    data() {
        return {
            getAllUrl: undefined,
            dataUrl: undefined,
            headers: [],
            items: [],
            selectedItems: [],
            modal: {
                header: undefined,
                confirm: undefined,
            },
            modalShow: false,
            data: undefined,
            isEdit: false
        }
    },
    created() {
        this.getItems();
		this.data = this.items;
    },
    methods: {
        showAddModal() {
            this.isEdit = false;
			this.data = this.items;
            this.modal.header = 'Добавление элемента';
            this.modal.confirm = 'Добавить';
            this.modalShow = true;
        },
        showEditModal() {
            if (this.selectedItems.length === 0) {
                return;
            }
            this.showEditModalDblClick(this.selectedItems[0]);
        },
        showEditModalDblClick(editId) {
			if(typeof(editId) != 'number')
				editId = editId.id;
            DataService.getData(this.dataUrl + editId)
                .then(data => {
                    this.data = data;
                    this.isEdit = true;
                    this.modal.header = 'Редактирование элемента';
                    this.modal.confirm = 'Сохранить';
                    this.modalShow = true;
                });
        },
        saveItem() {
			var dataUrlSave = '';
            if (!this.isEdit) {
				dataUrlSave = this.Save(this.data, "create");
                DataService.create(dataUrlSave)
                    .then(() => {
                        this.getItems();
                });
                location.reload();
            
            } else {
				dataUrlSave = this.Save(this.data, "update");
                DataService.update(this.dataUrl + this.data.id + dataUrlSave)
                    .then(() => {
                        this.getItems();
                    }); 
                location.reload();
            }
        },
        removeSelectedItems() {
            if (this.selectedItems.length === 0) {
                return;
            }
            if (confirm('Удалить выбранные элементы?')) {
                const promises = [];
                const self = this;
                this.selectedItems.forEach(item => {
                    promises.push(DataService.delete(this.dataUrl + item));
                });
                Promise.all(promises).then((results) => {
                    results.forEach(function (id) {
                        const index = self.selectedItems.indexOf(id);
                        if (index === - 1) {
                            return;
                        }
                        self.selectedItems.splice(index, 1);
                    });
                    this.getItems();
                });
            }
        }
    }
}

export default CatalogMixin;