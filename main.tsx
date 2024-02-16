import ReactDOM from 'react-dom/client'
import App from "./App"
import './index.css'

ReactDOM.createRoot(document.getElementById('telushelper')!).render(
    <App/> 
)

// Remove Preload scripts loading
postMessage({ payload: 'removeLoading' }, '*')

// Use contextBridge
window.ipcRenderer.on('main-process-message', (_event, message) => {
  console.log(message)
})
