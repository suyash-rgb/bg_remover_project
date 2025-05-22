import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter } from 'react-router-dom'
import {ClerkProvider} from '@clerk/clerk-react'

const PUBLISHABLE_KEY = import.meta.env.VITE_CLERK_PUBLISHABLE_KEY;

if(!PUBLISHABLE_KEY){
  throw new Error('Missig PUBLISHABLE_KEY in .env file')
}

createRoot(document.getElementById('root')).render(
  <BrowserRouter> 
    <ClerkProvider publishableKey={PUBLISHABLE_KEY}>
      <App />

    </ClerkProvider>
  </BrowserRouter>
)
 