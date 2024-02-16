import React, {useState,useEffect} from 'react'
import {useNavigate} from 'react-router-dom'
import "./MostTasks.css";

const Timer = () => {
  const [seconds, setSeconds] = useState(0);
  const [minutes, setMinutes] = useState(0);
  const [isActive, setIsActive] = useState(false);

  useEffect(() => {
    let interval;
    if (isActive) {
      interval = setInterval(() => {
        
        setSeconds(prevSeconds => {
          if (prevSeconds === 59) {
            
            setMinutes(prevMinutes => prevMinutes + 1);
            return 0;
          } else {
            return prevSeconds + 1;
          }
        });
      }, 1000); 
    } else {
      clearInterval(interval);
    }

    
    return () => clearInterval(interval);
  }, [isActive]); 

  const handleStart = () => {
    setIsActive(true);
    if(isActive){
      setIsActive(false)
    }
  };

  const handleReset = () => {
    setIsActive(false);
    setSeconds(0);
    setMinutes(0);
  };

  
  const formattedSeconds = seconds < 10 ? `0${seconds}` : seconds;
  const formattedMinutes = minutes < 10 ? `0${minutes}` : minutes;

  return (
    <div>
      <h1 className = "timerLabel"> Timer </h1>
      <h1 className = "timeLabel">{`${formattedMinutes}:${formattedSeconds}`}</h1>
      <button onClick={handleStart} id = "mostTasksStart">{isActive ? 'Pause' : 'Start'}</button>
      <button onClick={handleReset} id = "mostTasksReset">Reset</button>
    </div>
  );
}

  function MostTasks() {
    document.body.style.backgroundColor = "turquoise"
    document.body.style.margin = "0"
    document.body.style.placeItems = "center"
    document.body.style.minWidth = "200vh"
    document.body.style.minHeight = "200vh"
    document.body.style.overflowX = "hidden"
    document.body.style.overflowY = "auto"
    document.body.style.display = "flex"

   

    var [total, setTotal] = useState<number[]>(new Array(1).fill(0));
    var [number, setNumber] = useState<number[]>(new Array(70).fill(0));

    const navigate = useNavigate()

    useEffect(() => {
      const handleLoadAllValues = (_event: any, data: any) => {
          
        if (data.number) {
          setNumber(data.number);
        }
        
      };
      const handleLoadTotal = (_event: any, data: any) => {
      
          if (data.number) {
            setTotal(data.number);
          }
       
      };
  
      window.ipcRenderer.send('get-all-mosttasks');
      window.ipcRenderer.on('load-all-mosttasks', handleLoadAllValues);
      window.ipcRenderer.send('get-all-totalearnings');
      window.window.ipcRenderer.on('load-all-totalearnings',handleLoadTotal);
  
      return () => {
        window.window.ipcRenderer.removeListener('load-all-mosttasks', handleLoadAllValues);
        window.window.ipcRenderer.removeListener('load-all-totalearnings', handleLoadTotal);
        
      };
    }, []);

    const updateTotal = (newValue: number) => {
      setTotal((prevTotal) => {
        const updatedTotal = prevTotal[0] + newValue;
        return [updatedTotal];
      });
    };

  const task = new Array(70);
        task[0] = 0.032;
        task[1] = 0.039;
        task[2] = 0.045;
        task[3] = 0.064;
        task[4] = 0.077;
        task[5] = 0.08;
        task[6] = 0.087;
        task[7] = 0.097;
        task[8] = 0.116;
        task[9] = 0.129;
        task[10] = 0.145;
        task[11] = 0.161;
        task[12] = 0.193;
        task[13] = 0.225;
        task[14] = 0.241;
        task[15] = 0.257;
        task[16] = 0.286;
        task[17] = 0.29;
        task[18] = 0.322;
        task[19] = 0.354;
        task[20] = 0.386;
        task[21] = 0.402;
        task[22] = 0.418;
        task[23] = 0.434;
        task[24] = 0.45;
        task[25] = 0.483;
        task[26] = 0.515;
        task[27] = 0.531;
        task[28] = 0.563;
        task[29] = 0.579;
        task[30] = 0.611;
        task[31] = 0.643;
        task[32] = 0.676;
        task[33] = 0.708;
        task[34] = 0.724;
        task[35] = 0.772;
        task[36] = 0.804;
        task[37] = 0.82;
        task[38] = 0.869;
        task[39] = 0.965;
        task[40] = 1.013;
        task[41] = 1.029;
        task[42] = 1.062;
        task[43] = 1.11;
        task[44] = 1.158;
        task[45] = 1.206;
        task[46] = 1.255;
        task[47] = 1.287;
        task[48] = 1.303;
        task[49] = 1.351;
        task[50] = 1.399;
        task[51] = 1.448;
        task[52] = 1.544;
        task[53] = 1.641
        task[54] = 1.737;
        task[55] = 1.801;
        task[56] = 1.93;
        task[57] = 2.059;
        task[58] = 2.091;
        task[59] = 2.123;
        task[60] = 2.316;
        task[61] = 2.509;
        task[62] = 2.573;
        task[63] = 2.702;
        task[64] = 2.895;
        task[65] = 3.088;
        task[66] = 3.217;
        task[67] = 3.281;
        task[68] = 3.667;
        task[69] = 3.86;
  
  const time = new Array(70)
  time[0] = "10s";
  time[1] = "12s";
  time[2] = "14s";
  time[3] = "20s";
  time[4] = "24s";
  time[5] = "25s";
  time[6] = "27s";
  time[7] = "30s";
  time[8] = "36s";
  time[9] = "40s";
  time[10] = "45s";
  time[11] = "50s";
  time[12] = "1m";
  time[13] = "1m\n10s";
  time[14] = "1m\n15s";
  time[15] = "1m\n20s";
  time[16] = "1m\n29s";
  time[17] = "1m\n30s";
  time[18] = "1m\n40s";
  time[19] = "1m\n50s";
  time[20] = "2m";
  time[21] = "2m\n5s";
  time[22] = "2m\n10s";
  time[23] = "2m\n15s";
  time[24] = "2m\n20s";
  time[25] = "2m\n30s";
  time[26] = "2m\n40s";
  time[27] = "2m\n45s";
  time[28] = "2m\n55s";
  time[29] = "3m";
  time[30] = "3m\n10s";
  time[31] = "3m\n20s";
  time[32] = "3m\n30s";
  time[33] = "3m\n40s";
  time[34] = "3m\n45s";
  time[35] = "4m";
  time[36] = "4m\n10s";
  time[37] = "4m\n15s";
  time[38] = "4m\n30s";
  time[39] = "5m";
  time[40] = "5m\n15s";
  time[41] = "5m\n20s";
  time[42] = "5m\n30s";
  time[43] = "5m\n45s";
  time[44] = "6m";
  time[45] = "6m\n15s";
  time[46] = "6m\n30s";
  time[47] = "6m\n40s";
  time[48] = "6m\n45s";
  time[49] = "7m";
  time[50] = "7m\n15s";
  time[51] = "7m\n30s";
  time[52] = "8m"
  time[53] = "8m\n30s"
  time[54] = "9m"
  time[55] = "9m\n20s"
  time[56] = "10m"
  time[57] = "10m\n40s"
  time[58] = "10m\n50s"
  time[59] = "11m"
  time[60] = "12m"
  time[61] = "13m"
  time[62] = "13m\n20s"
  time[63] = "14m"
  time[64] = "15m"
  time[65] = "16m"
  time[66] = "16m\n40s"
  time[67] = "17m"
  time[68] = "19m"
  time[69] = "20m"


  const taskButtonClick = (index: number) => {
      setNumber((prevNumbers) => {
        const updatedNumbers = [...prevNumbers];
        updatedNumbers[index] += 1;
          
        
        window.window.ipcRenderer.send('update-mosttasks', { index, increment: 1, taskUpdate: task[index] });
        return updatedNumbers;
      });
      
      setTotal((prevTotal) => {
        const updatedTotal = prevTotal[0] + task[index];
        return [updatedTotal];
      });
    };

    const negativeButtonClick = (index: number) => {
      if (number[index] === 0) return;
  
      setNumber((prevNumbers) => {
        const updatedNumbers = [...prevNumbers];
        updatedNumbers[index] -= 1;
        window.window.ipcRenderer.send('update-mosttasks', { index, increment: -1, taskUpdate: -task[index] });
        return updatedNumbers;
      });

      setTotal((prevTotal) => {
        const updatedTotal = prevTotal[0] - task[index];
        return [updatedTotal];
      });
    };

  
    const clear = () => {
      var random = 0;
      for(let i = 0; i < number.length; i++){
        random += task[i]*number[i];
      }
      if(random === 0) return; 
      else if (!confirm('Are you sure?')) return;
      
      for(let i = 0; i < number.length; i++){
       updateTotal(-(task[i]*number[i]));
       number[i] = 0;
       setNumber([...number])
      }
      window.window.ipcRenderer.send('clear-all-mosttasks');
      window.ipcRenderer.send('update-mosttasks', { index: 1, increment: 0, taskUpdate: -random});
      
    };

  const renderTimes = (groupIndex: number) =>{
      return [...Array(13)].map((_,i) =>(
          <div key={i+ groupIndex*13}>
            <h4> {time[i+groupIndex*13]}</h4>
          </div>
      ));
  };

  const renderTimes2 = () => {
    return [...Array(4)].map((_, i) => (
      <div key={i + 4 * 13}>
        <h4>{time[i + 4 * 13].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}</h4>
      </div>
    ));
  };

  const renderTimes3 = () => {
    return [...Array(9)].map((_, i) => (
      <div key={(i + 4 * 13)+4}>
        <h4>{time[(i + 4 * 13)+4].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}</h4>
      </div>
    ));
  };

  const renderTimes4 = () => {
    return [...Array(5)].map((_, i) => (
      <div key={i + 5 * 13}>
        <h4>{time[i + 5 * 13].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}</h4>
      </div>
    ));
  };

  const renderTaskControls = (groupIndex: number) => {
    return [...Array(13)].map((_, i) => (
      <div key={i + groupIndex * 13}>
        <button className="plus" onClick={() => taskButtonClick(i + groupIndex * 13)}>
          +
        </button>
        <br/>
        <input
          type="text"
          className="task-input"
          value={number[i + groupIndex * 13].toString()}
          onChange={(e) =>
            setNumber([...number.slice(0, i + groupIndex * 13), +e.target.value, ...number.slice(i + groupIndex * 13 + 1)])
          }
          readOnly
        />
        <br />
        <button className="minus" onClick={() => negativeButtonClick(i + groupIndex * 13)}>
          -
        </button>
      </div>
    ));
  };

 

  const renderTaskControls2 = () => {
    return [...Array(5)].map((_, i) => (
      <div key={i + 5 * 13}>
        <button className="plus" onClick={() => taskButtonClick(i + 5 * 13)}>
          +
        </button>
        <br/>
        
        <input
          type="text"
          className="task-input"
          value={number[i + 5 * 13].toString()}
          onChange={(e) =>
            setNumber([...number.slice(0, i + 5 * 13), +e.target.value, ...number.slice(i + 5 * 13 + 1)])
          }
          readOnly
        />
        <br />
        
        <button className="minus" onClick={() => negativeButtonClick(i + 5 * 13)}>
          -
        </button>
      </div>
    ));
  };


  return (
    <>
    <div id = "mostTasks">
      <div className="app">
        <button className="backButton" onClick = {() => navigate('/telushelper')}>
          Back to Menu
        </button>
        <div className="labels">
          <h2 className="titleLabel">Most Tasks</h2>
          <h1 className="earningsValue">Earnings: {`$${Math.max(total[0],0).toFixed(3)}`}</h1>
          <button className="clear" onClick={clear}>Clear</button>
        </div>
        {[0, 1, 2, 3].map((groupIndex) => (
          <div key={groupIndex} className={`times${groupIndex}`}>
            {renderTimes(groupIndex)}
          </div>
        ))}
        <div className = "times4">
          {renderTimes2()}
        </div>
        <div className = "times5">
          {renderTimes3()}
        </div>
        <div className = "times6">
          {renderTimes4()}
        </div>
        
        {[0, 1, 2, 3, 4].map((groupIndex) => (
          <div key={groupIndex} className={`task-controls${groupIndex}`}>
            {renderTaskControls(groupIndex)}
          </div>
        ))}

        
        <div className = "task-controls5">
          {renderTaskControls2()}
        </div>
        <div id = 'mostTasksTimer'>
          {Timer()}
        </div>
      </div>
    </div>
    </>
  );
};



postMessage({ payload: 'removeLoading' }, '*')

export default MostTasks