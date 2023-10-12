<script>
export default {
  props: {
    headers: Array,
    items: Array,
    selectedItems: Array
  },
  emits: {
    dblclick: null
  },
  methods: {
    rowClick(id) {
      if (this.isSelected(id)) {
        var index = this.selectedItems.indexOf(id);
        if (index !== -1) {
          this.selectedItems.splice(index, 1);
        }
      } else {
        this.selectedItems.push(id);
      }
    },
    rowDblClick(id) {
      this.$emit('dblclick', id);
    },
    isSelected(id) {
      return this.selectedItems.includes(id);
    },
    dataConvert(data) {
      return data;
    }
  }
}
</script>

<template>
  <table class="table table-hover">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th v-for="header in this.headers"
          :id="header.name"
          scope="col">{{ header.label }}</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item, index) in this.items"
        @click="rowClick(item.id)"
        @dblclick="rowDblClick(item.id)"
        :class="{selected: isSelected(item.id)}">
      <th scope="row">{{ index + 1 }}</th>
      <td v-for="header in this.headers">
        {{ dataConvert(item[header.name]) }}
      </td>
    </tr>
    </tbody>
  </table>
</template>

<style scoped>
tbody tr:hover {
  cursor: pointer;
}
tr.selected {
  background-color: #0d6efd;
  opacity: 80%;
}
tbody tr {
  user-select: none;
}
</style>