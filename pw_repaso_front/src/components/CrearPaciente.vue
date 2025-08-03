<template>
  <div class="container_crearpaciente">
    <h1>Contenedor Hijo Crear Pacient</h1>
    <div class="formulario">
      <p type="cedula"><input type="text" v-model="cedula" /></p>

      <p type="nombre"><input type="text" v-model="nombre" /></p>

      <p type="apellido"><input type="text" v-model="apellido" /></p>

      <p type="Cedula Doctor"><input type="text" v-model="cedulaDoctor" /></p>

      <button @click="guardarPaciente()">Guardar Doctor</button>
    </div>
    <div v-if="mensajeExitoso" class="mensaje">
      {{mensajeExitoso}}
    </div>
  </div>
</template>

<script>
import { guardarFachada } from "@/clients/PacienteClient.js";

export default {
  data(){
    return{
      cedula:"",
      nombre:"",
      apellido:"",
      cedulaDoctor:"",
      mensajeExitoso: null,
    }
  },
  methods:{
    async guardarPaciente(){

      const bodyPaciente = {
        nombre: this.nombre,
        apellido: this.apellido,
        cedula: this.cedula,
        cedulaDoctor: this.cedulaDoctor
      }
      
      if (!this.mensajeExitoso) {        
        await guardarFachada(bodyPaciente);
      }

      this.mensajeExitoso = "Paciente Guardado Correctamente"

      setTimeout(() => {
        this.mensajeExitoso = null
        this.reiniciarVariables();         
        this.$emit("presionado")
      }, 2000);
               
    },
    reiniciarVariables(){
      this.nombre = "";
      this.apellido = "";
      this.cedula = "";
      this.cedulaDoctor = "";
    }
  }
};
</script>

<style scoped>
.container_crearpaciente{
  border: 2px solid;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.formulario {
  border: 10px solid;
  width: 15%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 20px;
  padding: 20px;
  border-radius: 20px;
}

p {
  width: 100%;
}

input {
  width: 100%;
  height: 20px;
}

button {
  padding: 10px;
  border-radius: 10px;
}

p:before {
  content: attr(type);
  display: block;
  text-align: left;
}
</style>