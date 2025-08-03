<template>
  <div class="container_pacienteview">
    <Paciente/>
  </div>
</template>

<script>
import Paciente from "@/components/Paciente.vue";
export default {
    components:{
        Paciente
    }

}
</script>

<style scoped>
.container_pacienteview{
    width: 99vw;
}
</style>