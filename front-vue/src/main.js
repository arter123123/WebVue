import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import './style.css'
import App from './App.vue'
import Material from './components/material.vue'
import TypeWarehouse from './components/typeWarehouse.vue'
import Warehouse from './components/warehouse.vue'
import WarehousesMaterials from './components/warehousesMaterials.vue'


const routes = [
    { path: '/', redirect: '/typeWarehouses' },
	{ path: '/materials', component: Material, meta: { label: 'Материалы' }},
    { path: '/typeWarehouses', component: TypeWarehouse, meta: { label: 'Типы склада' }},
    { path: '/warehouses', component: Warehouse, meta: { label: 'Склады' }},
    { path: '/warehousesmaterials', component: WarehousesMaterials, meta: { label: 'Склады_Материалы' }}
]

const router = createRouter({ 
    history: createWebHistory(),
    linkActiveClass: 'active',
    routes 
})

createApp(App).use(router).mount('#app')