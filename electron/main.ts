import { app, BrowserWindow, ipcMain } from 'electron'
import path from 'node:path'
import os from 'os'

// The built directory structure
//
// ├─┬─┬ dist
// │ │ └── index.html
// │ │
// │ ├─┬ dist-electron
// │ │ ├── main.js
// │ │ └── preload.js
// │


async function createDatabase (){
  const fs = require('fs');
  if(fs.existsSync(path.join(os.homedir(), 'telushelper.sqlite'))) return;
  
  
  const sqlite3 = require('sqlite3').verbose();
  const dbPath = path.join(os.homedir(), 'telushelper.sqlite');
  const db = new sqlite3.Database(dbPath)
  
  db.serialize(() => {
    db.run(`
        CREATE TABLE mosttasks (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            number INTEGER DEFAULT 0
        )
    `);
  
    for(let i = 0; i < 70; i++)
      db.run('INSERT INTO mosttasks (number) VALUES (0)');
  
    db.run(`
        CREATE TABLE search (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            number INTEGER DEFAULT 0
        )
    `);
  
    db.run(`
        CREATE TABLE auto (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            number INTEGER DEFAULT 0
        )
    `);
  
    for(let i = 0; i < 18; i++){
      db.run('INSERT INTO search (number) VALUES (0)');
      db.run('INSERT INTO auto (number) VALUES (0)');
      }
  
    db.run(`
        CREATE TABLE address (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            number INTEGER DEFAULT 0
        )
    `);
  
   
  
    for(let i = 0; i < 2; i++){
      db.run('INSERT INTO address (number) VALUES (0)');
    }
    
    db.run(`
    CREATE TABLE totalearnings (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        number INTEGER DEFAULT 0
    )
  `);
    db.run('INSERT INTO totalearnings (number) VALUES (0)')
  });
  
  db.close();

}

 function loadAllValues(table: string) {
    return new Promise((resolve, reject) => {
      const sqlite3 = require('sqlite3').verbose();
      const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
  
      const values: any = {};
  
      db.serialize(() => {
      
        db.all(`SELECT number FROM ${table}`, (err: any, rows: any) => {
  
          if (err) {
            console.error(err.message);
            reject(err);
            return;
          }
          values.number = rows.map((row: any) => row.number);
          resolve(values);
        });
      });
  
      db.close();
    });
}

process.env.DIST = path.join(__dirname, '../dist')
process.env.VITE_PUBLIC = app.isPackaged ? process.env.DIST : path.join(process.env.DIST, '../public')


let win: BrowserWindow | null
// 🚧 Use ['ENV_NAME'] avoid vite:define plugin - Vite@2.x
const VITE_DEV_SERVER_URL = process.env['VITE_DEV_SERVER_URL']

function createWindow() {
    win = new BrowserWindow({
      icon: path.join(__dirname, 'telus.ico'),
      webPreferences: {
        preload: path.join(__dirname, 'preload.js'),
      },
      autoHideMenuBar: true,
      resizable:false
      
    })
  
    // Test active push message to Renderer-process.
    win.webContents.on('did-finish-load',  () =>  {
      win?.webContents.send('main-process-message', "Hello World")
    })
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*IPC Main calls to generate all values to be rendered for each table of data*/
  
    ipcMain.on('get-all-totalearnings', async(event) => {
      try{
      var total = await loadAllValues('totalearnings');
      event.reply('load-all-totalearnings', total);
      }catch(error){
        console.log("Error getting the earnings")
      }
    });
  
    ipcMain.on('get-all-mosttasks',async(event) =>{
      try {
      var values = await loadAllValues('mosttasks');
      event.reply('load-all-mosttasks',values);
      }
      catch(error){
          console.log(error);
      }
    });
  
    ipcMain.on('get-all-search',async(event) =>{
      try {
      var values = await loadAllValues('search');
      event.reply('load-all-search',values);
      }
      catch(error){
          console.log(error);
      }
    });
  
    ipcMain.on('get-all-auto',async(event) =>{
      try {
      var values = await loadAllValues('auto');
      event.reply('load-all-auto',values);
      }
      catch(error){
          console.log(error);
      }
    });
  
    ipcMain.on('get-all-address',async(event) =>{
      try {
      var values = await loadAllValues('address');
      event.reply('load-all-address',values);
      }
      catch(error){
          console.log(error);
      }
    });
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /*Update the values of each of the tables of data, to be refractored into the renderer*/
  
    ipcMain.on('update-mosttasks', (_event, { index, increment, taskUpdate}) => {
      const sqlite3 = require('sqlite3').verbose();
      const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
  
      db.serialize(() => {
        db.run('UPDATE mosttasks SET number = number + ? WHERE id = ?', [increment, index + 1], (err: any) => {
          if (err) {
            console.error(err.message);
          }
        });
  
        
        db.run('UPDATE totalearnings SET number = number + ? WHERE id = 1', [taskUpdate], (err: any) => {
  
          if (err) {
            console.error("Total Earnings error");
          }
        });
      });
  
      db.close();
    });
  
    ipcMain.on('update-search', (_event, { index, increment, taskUpdate}) => {
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        db.serialize(() => {
          db.run('UPDATE search SET number = number + ? WHERE id = ?', [increment, index + 1], (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });
      
          
          db.run('UPDATE totalearnings SET number = number + ? WHERE id = 1', [taskUpdate], (err: any) => {
  
            if (err) {
              console.error("Total Earnings error");
            }
          });
        });
      
        db.close();
      });
  
      ipcMain.on('update-auto', (_event, { index, increment, taskUpdate}) => {
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        db.serialize(() => {
          db.run('UPDATE auto SET number = number + ? WHERE id = ?', [increment, index + 1], (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });
      
          
          db.run('UPDATE totalearnings SET number = number + ? WHERE id = 1', [taskUpdate], (err: any) => {
  
            if (err) {
              console.error("Total Earnings error");
            }
          });
        });
      
        db.close();
      });
  
      ipcMain.on('update-address', (_event, { index, increment, taskUpdate}) => {
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        db.serialize(() => {
          db.run('UPDATE address SET number = number + ? WHERE id = ?', [increment, index + 1], (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });
      
          
          db.run('UPDATE totalearnings SET number = number + ? WHERE id = 1', [taskUpdate], (err: any) => {
  
            if (err) {
              console.error("Total Earnings error");
            }
          });
        });
      
        db.close();
      });
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*Clear all of the values for the given table (including the total earnings), to be refractored into the renderer*/
  
      ipcMain.on('clear-all-mosttasks', () => {
        
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        
        db.run('UPDATE mosttasks SET number = 0', (err: any) => {
          if (err) {
            console.error(err.message);
          }
        });  
      
        db.close();
      });
  
      ipcMain.on('clear-all-search', () => {
        
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        
        db.run('UPDATE search SET number = 0', (err: any) => {
          if (err) {
            console.error(err.message);
          }
        });  
      
        db.close();
      });
  
      ipcMain.on('clear-all-auto', () => {
        
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        
        db.run('UPDATE auto SET number = 0', (err: any) => {
          if (err) {
            console.error(err.message);
          }
        });  
      
        db.close();
      });
  
      ipcMain.on('clear-all-address', () => {
        
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        
        db.run('UPDATE address SET number = 0', (err: any) => {
          if (err) {
            console.error(err.message);
          }
        });  
      
        db.close();
      });
  
      ipcMain.on('clear-all', () => {
        
        const sqlite3 = require('sqlite3').verbose();
        const db = new sqlite3.Database(path.join(os.homedir(), 'telushelper.sqlite'));
      
        db.serialize(() => {
          db.run('UPDATE mosttasks SET number = 0', (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });  
  
          db.run('UPDATE search SET number = 0', (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });  
  
          db.run('UPDATE auto SET number = 0', (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });  
  
          db.run('UPDATE address SET number = 0', (err: any) => {
            if (err) {
              console.error(err.message);
            }
          }); 
          
          db.run('UPDATE totalearnings SET number = 0', (err: any) => {
            if (err) {
              console.error(err.message);
            }
          });  
  
      });  
      
      
        db.close();
      });
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    if (VITE_DEV_SERVER_URL) {
      win.loadURL(VITE_DEV_SERVER_URL)
    } else {
      // win.loadFile('dist/index.html')
      win.loadFile(path.join(__dirname, '../dist/index.html '))
    }
  }
  
  // Quit when all windows are closed, except on macOS. There, it's common
  // for applications and their menu bar to stay active until the user quits
  // explicitly with Cmd + Q.
  app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
      app.quit()
      win = null
    }
  })
  
  app.on('activate', () => {
    
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow()
    }
})

app.whenReady().then(createDatabase).then(createWindow)
