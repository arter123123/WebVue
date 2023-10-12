<script>
    export default {
        props: {
            header: String,
            confirm: String,
            visible: Boolean
        },
        emits: {
            done: null,
            'update:visible': (value) => {
                if (typeof value !== 'boolean') {
                    throw 'Value is not a boolean';
                }
                return true;
            }
        },
        methods: {
            hide() {
                this.$emit('update:visible', false);
            },
            done() {
                if (this.$refs.form.checkValidity()) {
                    this.$emit('done');
                    this.hide();
                } else {
                    this.$refs.form.reportValidity();
                }
            }
        }
    }
</script>

<template>
    <div class="modal fade" tabindex="-1" aria-hidden="true"
        :class="{ 'modal-show': this.visible, 'show': this.visible }">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">{{ header }}</h1>
                    <button type="button" class="btn-close" aria-label="Close"
                        @click.prevent="hide"></button>
                </div>
                <div class="modal-body">
                    <form @submit.prevent="done" ref="form">
                        <slot></slot>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                        @click.prevent="hide">Закрыть</button>
                    <button type="button" class="btn btn-primary"
                        @click.prevent="done">{{ confirm }}</button>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.modal-show {
    display: block;
}
</style>