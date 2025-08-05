import axios from "axios";

const URL_API = "http://localhost:8081/api/matricula/v1/materias"

const guardaMateria = async (body) => {
    axios.post(URL_API, body)
}

const obtenerTodas = async () => {
    const response = axios.get(URL_API).then(res => res.data)
    return response;
}

const obtenerURLInfo = async (URL)=>{
    const respose = axios.get(URL).then(res => res.data)
    return respose

}

const eliminarPorId = async (id) => {
    axios.delete(`${URL_API}/${id}`)
}

// Funciones Fachada

export const guardaMateriaFachada = async (body) => {
    await guardaMateria(body)
}

export const obtenerTodasFachada = async () => {
    return await obtenerTodas()
}

export const obtenerURLInfoFachada = async (URL) => {
    return await obtenerURLInfo(URL)
}

export const eliminarPorIdFachada = async (id) => {
    await eliminarPorId(id)
}