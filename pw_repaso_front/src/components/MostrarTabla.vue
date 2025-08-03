<template>
  <div class="continaer_mostrartabla">
    <h1>Cotenedor Hijo Mostrar Tabla</h1>
    <table border="1" cellspacing=0>
        <thead>
            <tr>
                <th>Apellido <br> Paciente</th>
                <th>Nombre <br> Paciente</th>
                <th>Cedula <br> Paciente</th>
                <th>Nombre <br> Doctor</th>
                <th>Cedula <br> Doctor</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="paciente in pacientes" :key="paciente.id">
                <td>{{paciente.apellido}}</td>
                <td>{{paciente.nombre}}</td>
                <td>{{paciente.cedula}}</td>
                <td>{{paciente.nombreDoctor}}</td>
                <td>{{paciente.cedulaDoctor}}</td>
            </tr>
        </tbody>
    </table>
  </div>
</template>

<script>
import { obtenerTodosFachada } from "@/clients/PacienteClient.js";
export default {
    data(){
        return{
            pacientes:[]
        }
    },
    methods:{
        async obtenerPacientes(){
            this.pacientes = await obtenerTodosFachada();
        }
    },
    async beforeMount(){
        await this.obtenerPacientes()
    }
};
</script>

<style scoped>
.continaer_mostrartabla{
    border: 2px solid;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

table{
    width: 100%;
}
</style>