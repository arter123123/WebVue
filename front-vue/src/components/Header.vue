<script>
    export default {
        methods: {
            getRoutes() {
                return this.$router.options.routes.filter(route => route.meta?.hasOwnProperty('label'));
            }
        }
    }
</script>

<template>
	<div class="container">
	    <nav class="navbar navbar-expand-sm bg-light">
	    <ul class="menu-bar navbar-nav">
             <li class="nav-item" 
	             v-for="route in this.getRoutes()">
                  <router-link class="nav-link" :to="route.path">{{ route.meta.label }}</router-link>
             </li>
        </ul>
	    </nav>
    </div>
</template>

<style scoped>
.menu-bar {
  border-radius: 25px;
  height: -webkit-fit-content;
  height: -moz-fit-content;
  height: fit-content;
  display: inline-flex;
  background-color: rgba(0, 0, 0, 0.4);
  -webkit-backdrop-filter: blur(10px);
  backdrop-filter: blur(10px);
  width: 100%;
  align-items: center;
  padding: 0 10px;
  margin: 10px 0 0 0;
}
.menu-bar li {
  list-style: none;
  color: white;
  font-family: sans-serif;
  font-weight: bold;
  padding: 12px 16px;
  margin: 0 8px;
  width: 50%;
  position: relative;
  cursor: pointer;
  white-space: nowrap;
  text-align: center;
}
.menu-bar li::before {
  content: " ";
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  z-index: -1;
  transition: 0.2s;
  border-radius: 25px;
}
.menu-bar li:hover {
  color: black;
}
.menu-bar li:hover::before {
  background: linear-gradient(to bottom, #e8edec, #d2d1d3);
  box-shadow: 0px 3px 20px 0px black;
  transform: scale(1.2);
}
</style>