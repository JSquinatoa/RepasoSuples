<template>
  <div class="container_materiaconsultar">
    <h1>Consultar las Materias</h1>
    <Tabla
      @consultarInfo="mostrarMateria($event)"
      @eliminar="reiniciarForm()"
    />
    <Mostrar ref="fomrulario" />
  </div>
</template>

<script>
import Tabla from "@/components/Tabla.vue";
import Mostrar from "@/components/Mostrar.vue";
import { obtenerURLInfoFachada } from "@/clients/MateriaClient.js";

export default {
  data() {
    return {};
  },
  components: {
    Tabla,
    Mostrar,
  },
  methods: {
    async mostrarMateria(URL) {
      console.log("recibio Padre", URL);
      const materia = await obtenerURLInfoFachada(URL);
      console.log(materia);
      this.$refs.fomrulario.rellenarForm(materia);
    },
    reiniciarForm() {
      this.$refs.fomrulario.reiniciarVaraibles();
    },
  },
};
</script>

<style>
.container_materiaconsultar{

}
</style>