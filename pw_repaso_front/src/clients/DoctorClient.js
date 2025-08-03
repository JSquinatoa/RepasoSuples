import axios from "axios";

const URL_API = "http://localhost:8081/api/matricula/v1/doctores"

// funciones que son de la api

// alt mas 96

const guardar = async (body) => {
    axios.post(URL_API, body);
}

const verificar = async (usuario) => {
    const response = axios.post(`${URL_API}/verificacion`, usuario).then(res => res.data)
    return response
}

// funciones fachada
export const guardarFachada = async (body) => {
    await guardar(body)
}

export const verificarFachada = async (usuario) => {
    return await verificar(usuario);
}

