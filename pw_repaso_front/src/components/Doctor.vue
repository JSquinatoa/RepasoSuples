<template>
    <div class="container_doctor">
        <h1>Crear un Doctor</h1>
        <div class="formulario">
            <p type="cedula"><input type="text" v-model="cedula"></p>    
            {{cedula}}        
            <p type="nombre"><input type="text" v-model="nombre"></p>            
            {{nombre}}
            <p type="apellido"><input type="text" v-model="apellido"></p>            
            {{apellido}}
            <button @click="guardarDoctor()">Guardar Doctor</button>
        </div>
        <div v-if="mensajeExito" class="mensaje">
            <h2>{{mensajeExito}}</h2>
        </div>
    </div>
  
</template>

<script>
import { guardarFachada, verificarFachada} from "@/clients/DoctorClient.js";
import router from '@/router';


export default {
    data(){
        return{
            cedula:"",
            nombre:"",
            apellido:"",
            mensajeExito : false
        }
    },
    methods:{
        async guardarDoctor(){
            const bodyDoctor={
                nombre: this.nombre,
                apellido: this.apellido,
                cedula: this.cedula
            }            

            // Para poner Mensajes

            // el control del boton
            if (!this.mensajeExito) {
                await guardarFachada(bodyDoctor);                
            }

            this.mensajeExito = "Doctor Creado correctamente"

            // reincia
            setTimeout(() => {
                this.mensajeExito = null
                this.reiniciarVariables()
            }, 2000);
        },
        reiniciarVariables(){
            this.nombre ="";
            this.apellido="";
            this.cedula="";
        },
    },
    async beforeMount(){
        const usuario = {
            cedula: "1751872399",
            password: "1234"
        }

        const isVerificado = await verificarFachada(usuario);
        console.log(await isVerificado);
        console.log(await typeof isVerificado);
       
        localStorage.setItem("rol", await isVerificado)          
        
        console.log(localStorage.getItem("rol"))

        if (isVerificado) {           
            
            router.push("paciente")
        }

        
        
    }

}
</script>

<style scoped>
.container_doctor{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    gap: 50px;
}

.formulario{
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

p{
    width: 100%;
}

input{
    width: 100%;
    height: 20px;    
}

button{
    padding: 10px;
    border-radius: 10px;
}

p:before{
    content: attr(type);
    display: block;
    text-align: left;    
}

</style>