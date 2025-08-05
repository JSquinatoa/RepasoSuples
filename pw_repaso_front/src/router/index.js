import { createRouter, createWebHistory } from 'vue-router'
import DoctorView from "@/views/DoctorView.vue"
import PacienteView from "@/views/PacienteView.vue"
import MateriaVIew from "@/views/MateriaVIew.vue"
import MateriaConsultarView from "@/views/MateriaConsultarView.vue"

const routes = [
  {
    path: '/',
    name: 'doctor',
    component: DoctorView
  },
  {
    path: '/paciente',
    name: 'paciente',
    component: PacienteView
  },
  {
    path: '/crear',
    name: 'crear',
    component: MateriaVIew
  },
  {
    path: '/consultar',
    name: 'consultar',
    component: MateriaConsultarView
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
