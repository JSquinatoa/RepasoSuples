<template>
  <div class="contianer_paciente">
    <h1>Contenedor Padre</h1>
    <CrearPaciente @presionado="llmoHijo()"/>
    <MostrarTabla ref="tabla"/>
  </div>
</template>

<script>
import CrearPaciente from "@/components/CrearPaciente.vue";
import MostrarTabla from "@/components/MostrarTabla.vue";
export default {
  components: {
    CrearPaciente,
    MostrarTabla,
  },
  methods:{
    llmoHijo(){
      this.$refs.tabla.obtenerPacientes();      
    }
  }
};
</script>

<style scoped>
.contianer_paciente{
  display: flex;
  flex-direction: column;
  border: 2px solid red;
  justify-content: center;
  align-items: center;
}
</style>