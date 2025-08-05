<template>
  <div class="container_materia">
    <h1>Crear una nueva materia</h1>
    <div class="formulario">
      <p type="Nombre"><input type="text" v-model="nombre" /></p>
      <p type="Codigo"><input type="text" v-model="codigo" /></p>
      <p type="Numero de Creditos">
        <input type="number" v-model="numeroCreditos" />
      </p>
      <p type="Profesor"><input type="text" v-model="profesor" /></p>
      <button @click="crearMateria()">Guardar Materia</button>
    </div>
  </div>
</template>

<script>
import { guardaMateriaFachada } from "@/clients/MateriaClient.js";
export default {
  data() {
    return {
      nombre: "",
      codigo: "",
      numeroCreditos: 0,
      profesor: "",
    };
  },
  methods: {
    async crearMateria() {
      const bodyMateria = {
        nombre: this.nombre,
        codigo: this.codigo,
        numeroCreditos: this.numeroCreditos,
        profesor: this.profesor
      }

      await guardaMateriaFachada(bodyMateria)
    },
  },
};
</script>

<style scoped>
.container_materia {
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