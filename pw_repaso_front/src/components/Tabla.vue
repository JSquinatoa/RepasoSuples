<template>
  <div class="continaer_tabla">
    <table border="1" cellspcing="0" >
        <thead>
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Numero de Créditos</th>
                <th>Acción</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="materia in materias" :key="materia.id">
                <td>{{materia.codigo}}</td>
                <td>{{materia.nombre}}</td>
                <td>{{materia.numeroCreditos}}</td>
                <td><button @click="verInformacion(materia._links.materiaCompleta)">Ver</button></td>
                <td><button @click="eliminar(materia.id)">Eliminar</button></td>
            </tr>
        </tbody>

    </table>
    
  </div>
</template>

<script>
import { obtenerTodasFachada, eliminarPorIdFachada } from "@/clients/MateriaClient.js";
export default {
    data(){
        return{
            materias:[]
        }
    },
    methods:{
        async eliminar(id){
            await eliminarPorIdFachada(id)
            setTimeout(async () => {
                await this.mostrarTabla();
                this.$emit("eliminar")
            }, 1000);        
        },
        async mostrarTabla(){
            this.materias = await obtenerTodasFachada()
            console.log(this.materias);  
        },
        verInformacion (URL){
            this.$emit("consultarInfo", URL)
        }
    },
    async beforeMount(){
        await this.mostrarTabla()
        
    }
};
</script>

<style scoped>
.continaer_tabla{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
</style>