import axios from "axios";

const URL_API = "http://localhost:8081/api/matricula/v1/pacientes"

// Funciones api

const guardar = async (body) => {
    axios.post(URL_API, body)
}

const obtenerTodos = async () =>{
    const reponse = axios.get(URL_API).then(res => res.data)
    return reponse
}
// Funciones Fachada

export const guardarFachada = async (body) => {
    await guardar(body)
}

export const obtenerTodosFachada = async () =>{
    return await obtenerTodos();
}