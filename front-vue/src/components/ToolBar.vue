<script>
    export default {
        props: {

        },
        emits: {
            add: null,
            edit: null,
            remove: null
        },
        methods: {
            add() {
                this.$emit('add');
            },
            edit() {
                this.$emit('edit');
            },
            remove() {
                this.$emit('remove');
            },
        }
    }
</script>

<template>
    <div class="btn-group mt-2" role="group">
        <button type="button" class="btn btn-success"
            @click.prevent="add">
            Добавить
        </button>
        <button type="button" class="btn btn-warning"
            @click.prevent="edit">
            Изменить
        </button>
        <button type="button" class="btn btn-danger"
            @click.prevent="remove">
            Удалить
        </button>
    </div>
</template>

<style scoped>
.btn {
    min-width: 140px;
}
</style>