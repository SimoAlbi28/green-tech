import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // proxy per mandare le chiamate /api al backend spring boot
    proxy: {
      '/api': 'http://localhost:8080'
    }
  }
})
