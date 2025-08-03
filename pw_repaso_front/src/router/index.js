import { createRouter, createWebHistory } from 'vue-router'
import DoctorView from "@/views/DoctorView.vue"
import PacienteView from "@/views/PacienteView.vue"

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


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
