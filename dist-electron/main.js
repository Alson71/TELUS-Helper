"use strict";
const electron = require("electron");
const path = require("node:path");
const os = require("os");
async function createDatabase() {
  const fs = require("fs");
  if (fs.existsSync(path.join(os.homedir(), "telushelper.sqlite")))
    return;
  const sqlite3 = require("sqlite3").verbose();
  const dbPath = path.join(os.homedir(), "telushelper.sqlite");
  const db = new sqlite3.Database(dbPath);
  db.serialize(() => {
    db.run(`
      CREATE TABLE mosttasks (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          number INTEGER DEFAULT 0
      )
  `);
    for (let i = 0; i < 70; i++)
      db.run("INSERT INTO mosttasks (number) VALUES (0)");
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
    for (let i = 0; i < 18; i++) {
      db.run("INSERT INTO search (number) VALUES (0)");
      db.run("INSERT INTO auto (number) VALUES (0)");
    }
    db.run(`
      CREATE TABLE address (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          number INTEGER DEFAULT 0
      )
  `);
    for (let i = 0; i < 2; i++) {
      db.run("INSERT INTO address (number) VALUES (0)");
    }
    db.run(`
  CREATE TABLE totalearnings (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      number INTEGER DEFAULT 0
  )
`);
    db.run("INSERT INTO totalearnings (number) VALUES (0)");
  });
  db.close();
}
function loadAllValues(table) {
  return new Promise((resolve, reject) => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    const values = {};
    db.serialize(() => {
      db.all(`SELECT number FROM ${table}`, (err, rows) => {
        if (err) {
          console.error(err.message);
          reject(err);
          return;
        }
        values.number = rows.map((row) => row.number);
        resolve(values);
      });
    });
    db.close();
  });
}
process.env.DIST = path.join(__dirname, "../dist");
process.env.VITE_PUBLIC = electron.app.isPackaged ? process.env.DIST : path.join(process.env.DIST, "../public");
let win;
const VITE_DEV_SERVER_URL = process.env["VITE_DEV_SERVER_URL"];
function createWindow() {
  win = new electron.BrowserWindow({
    icon: path.join(__dirname, "telus.ico"),
    webPreferences: {
      preload: path.join(__dirname, "preload.js")
    },
    autoHideMenuBar: true,
    resizable: false
  });
  win.webContents.on("did-finish-load", () => {
    win == null ? void 0 : win.webContents.send("main-process-message", "Hello World");
  });
  electron.ipcMain.on("get-all-totalearnings", async (event) => {
    try {
      var total = await loadAllValues("totalearnings");
      event.reply("load-all-totalearnings", total);
    } catch (error) {
      console.log("Error getting the earnings");
    }
  });
  electron.ipcMain.on("get-all-mosttasks", async (event) => {
    try {
      var values = await loadAllValues("mosttasks");
      event.reply("load-all-mosttasks", values);
    } catch (error) {
      console.log(error);
    }
  });
  electron.ipcMain.on("get-all-search", async (event) => {
    try {
      var values = await loadAllValues("search");
      event.reply("load-all-search", values);
    } catch (error) {
      console.log(error);
    }
  });
  electron.ipcMain.on("get-all-auto", async (event) => {
    try {
      var values = await loadAllValues("auto");
      event.reply("load-all-auto", values);
    } catch (error) {
      console.log(error);
    }
  });
  electron.ipcMain.on("get-all-address", async (event) => {
    try {
      var values = await loadAllValues("address");
      event.reply("load-all-address", values);
    } catch (error) {
      console.log(error);
    }
  });
  electron.ipcMain.on("update-mosttasks", (_event, { index, increment, taskUpdate }) => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.serialize(() => {
      db.run("UPDATE mosttasks SET number = number + ? WHERE id = ?", [increment, index + 1], (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE totalearnings SET number = number + ? WHERE id = 1", [taskUpdate], (err) => {
        if (err) {
          console.error("Total Earnings error");
        }
      });
    });
    db.close();
  });
  electron.ipcMain.on("update-search", (_event, { index, increment, taskUpdate }) => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.serialize(() => {
      db.run("UPDATE search SET number = number + ? WHERE id = ?", [increment, index + 1], (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE totalearnings SET number = number + ? WHERE id = 1", [taskUpdate], (err) => {
        if (err) {
          console.error("Total Earnings error");
        }
      });
    });
    db.close();
  });
  electron.ipcMain.on("update-auto", (_event, { index, increment, taskUpdate }) => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.serialize(() => {
      db.run("UPDATE auto SET number = number + ? WHERE id = ?", [increment, index + 1], (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE totalearnings SET number = number + ? WHERE id = 1", [taskUpdate], (err) => {
        if (err) {
          console.error("Total Earnings error");
        }
      });
    });
    db.close();
  });
  electron.ipcMain.on("update-address", (_event, { index, increment, taskUpdate }) => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.serialize(() => {
      db.run("UPDATE address SET number = number + ? WHERE id = ?", [increment, index + 1], (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE totalearnings SET number = number + ? WHERE id = 1", [taskUpdate], (err) => {
        if (err) {
          console.error("Total Earnings error");
        }
      });
    });
    db.close();
  });
  electron.ipcMain.on("clear-all-mosttasks", () => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.run("UPDATE mosttasks SET number = 0", (err) => {
      if (err) {
        console.error(err.message);
      }
    });
    db.close();
  });
  electron.ipcMain.on("clear-all-search", () => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.run("UPDATE search SET number = 0", (err) => {
      if (err) {
        console.error(err.message);
      }
    });
    db.close();
  });
  electron.ipcMain.on("clear-all-auto", () => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.run("UPDATE auto SET number = 0", (err) => {
      if (err) {
        console.error(err.message);
      }
    });
    db.close();
  });
  electron.ipcMain.on("clear-all-address", () => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.run("UPDATE address SET number = 0", (err) => {
      if (err) {
        console.error(err.message);
      }
    });
    db.close();
  });
  electron.ipcMain.on("clear-all", () => {
    const sqlite3 = require("sqlite3").verbose();
    const db = new sqlite3.Database(path.join(os.homedir(), "telushelper.sqlite"));
    db.serialize(() => {
      db.run("UPDATE mosttasks SET number = 0", (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE search SET number = 0", (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE auto SET number = 0", (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE address SET number = 0", (err) => {
        if (err) {
          console.error(err.message);
        }
      });
      db.run("UPDATE totalearnings SET number = 0", (err) => {
        if (err) {
          console.error(err.message);
        }
      });
    });
    db.close();
  });
  if (VITE_DEV_SERVER_URL) {
    win.loadURL(VITE_DEV_SERVER_URL);
  } else {
    win.loadFile(path.join(__dirname, "../dist/index.html "));
  }
}
electron.app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    electron.app.quit();
    win = null;
  }
});
electron.app.on("activate", () => {
  if (electron.BrowserWindow.getAllWindows().length === 0) {
    createWindow();
  }
});
electron.app.whenReady().then(createDatabase).then(createWindow);
