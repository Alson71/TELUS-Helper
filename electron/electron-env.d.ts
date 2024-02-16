/// 



// Used in Renderer process, expose in `preload.ts`
interface Window {
  ipcRenderer: import('electron').IpcRenderer
  ipcMain: import('electron').IpcMain
}
