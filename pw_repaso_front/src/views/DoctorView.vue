<template>
  <div class="container_doctorview">
    <Doctor />
  </div>
</template>

<script>
import Doctor from "@/components/Doctor.vue";
export default {
  components: {
    Doctor,
  },
};
</script>

<style scoped>
.container_doctorview {
  width: 99vw;
}
</style>