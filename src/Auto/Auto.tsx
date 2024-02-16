import React, {useState,useEffect} from 'react'
import {useNavigate} from 'react-router-dom'
import "./Auto.css"

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

export default function Auto() {
  document.body.style.backgroundColor = "rgb(117, 109, 191)"
  document.body.style.margin = "0"
  document.body.style.placeItems = "center"
  document.body.style.minWidth = "200vh"
  document.body.style.minHeight = "100vh"
  document.body.style.overflowX = "hidden"
  document.body.style.overflowY = "auto"
  document.body.style.display = "flex"

  var [total, setTotal] = useState<number[]>(new Array(1).fill(0));
  var [number, setNumber] = useState<number[]>(new Array(18).fill(0));

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

    window.ipcRenderer.send('get-all-auto');
    window.ipcRenderer.on('load-all-auto', handleLoadAllValues);
    window.ipcRenderer.send('get-all-totalearnings');
    window.ipcRenderer.on('load-all-totalearnings',handleLoadTotal);

    return () => {
      window.ipcRenderer.removeListener('load-all-auto', handleLoadAllValues);
      window.ipcRenderer.removeListener('load-all-totalearnings', handleLoadTotal);
      
    };
  }, []);

  const updateTotal = (newValue: number) => {
    setTotal((prevTotal) => {
      const updatedTotal = prevTotal[0] + newValue;
      return [updatedTotal];
    });
  };

    const tasks = new Array(18);
        tasks[0] = 0.276;
        tasks[1] = 0.307;
        tasks[2] = 0.353;
        tasks[3] = 0.583;
        tasks[4] = 0.629;
        tasks[5] = 0.675;
        tasks[6] = 0.905;
        tasks[7] = 0.997;
        tasks[8] = 1.135;
        tasks[9] = 1.457;
        tasks[10] = 1.687;
        tasks[11] = 1.825;
        tasks[12] = 1.871;
        tasks[13] = 2.101;
        tasks[14] = 2.239;
        tasks[15] = 2.331;
        tasks[16] = 2.561;
        tasks[17] = 2.791;

        const time = new Array(18);
        time[0] = "1m\n30s";
        time[1] = "1m\n40s";
        time[2] = "1m\n55s";
        time[3] = "3m\n10s";
        time[4] = "3m\n25s";
        time[5] = "3m\n40s";
        time[6] = "4m\n55s";
        time[7] = "5m\n25s";
        time[8] = "6m\n10s";
        time[9] = "7m\n55s";
        time[10] = "9m\n10s";
        time[11] = "9m\n55s";
        time[12] = "10m\n10s";
        time[13] = "11m\n25s";
        time[14] = "12m\n10s";
        time[15] = "12m\n40s";
        time[16] = "13m\n55s";
        time[17] = "15m\n10s";
        
  
        const taskButtonClick = (index: number) => {
          setNumber((prevNumbers) => {
            const updatedNumbers = [...prevNumbers];
            updatedNumbers[index] += 1;
              
            
            window.ipcRenderer.send('update-auto', { index, increment: 1, taskUpdate: tasks[index] });
            return updatedNumbers;
          });
          
          setTotal((prevTotal) => {
            const updatedTotal = prevTotal[0] + tasks[index];
            return [updatedTotal];
          });
        };
  
        const negativeButtonClick = (index: number) => {
          if (number[index] === 0) return;
      
          setNumber((prevNumbers) => {
            const updatedNumbers = [...prevNumbers];
            updatedNumbers[index] -= 1;
            window.ipcRenderer.send('update-auto', { index, increment: -1, taskUpdate: -tasks[index] });
            return updatedNumbers;
          });
    
          setTotal((prevTotal) => {
            const updatedTotal = prevTotal[0] - tasks[index];
            return [updatedTotal];
          });
        };

        const clear = () => {
          var random = 0;
          for(let i = 0; i < number.length; i++){
            random += tasks[i]*number[i];
          }
          if(random === 0) return; 
          else if (!confirm('Are you sure?')) return;
          
          for(let i = 0; i < number.length; i++){
           updateTotal(-tasks[i]*number[i]);
           number[i] = 0;
           setNumber([...number])
          }
          
          window.ipcRenderer.send('clear-all-auto');
          window.ipcRenderer.send('update-auto', { index: 1, increment: 0, taskUpdate: -random});
          
        };
    
    const renderTimes = () =>{
      return [...Array(12)].map((_,i) =>(
          <div key={i}>
            <h4> {time[i].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}</h4>
          </div>
      ));
  };
  const renderTimes2 = () => {
    return [...Array(5)].map((_, i) => (
      <div key={i + 13}>
        <h4>{time[i + 13].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}</h4>
      </div>
    ));
  };

    const renderTaskControls = () => {
      return [...Array(13)].map((_, i) => (
        <div key={i}>
          <button className="plus" onClick={() => taskButtonClick(i)}>
            +
          </button>
          <br/>
          <input
            type="text"
            className="task-input"
            value={number[i].toString()}
            onChange={(e) =>
              setNumber([...number.slice(0, i), +e.target.value, ...number.slice(i)])
            }
            readOnly
          />
          <br />
          <button className="minus" onClick={() => negativeButtonClick(i)}>
            -
          </button>
        </div>
      ));
    };
    const renderTaskControls2 = () => {
      return [...Array(5)].map((_, i) => (
        <div key={i + 13}>
          <button className="plus" onClick={() => taskButtonClick(i + 13)}>
            +
          </button>
          <br/>
          <input
            type="text"
            className="task-input"
            value={number[i + 13].toString()}
            onChange={(e) =>
              setNumber([...number.slice(0, i + 13), +e.target.value, ...number.slice(i + 14)])
            }
            readOnly
          />
          <br />
          <button className="minus" onClick={() => negativeButtonClick(i + 13)}>
            -
          </button>
        </div>
      ));
    };
    return (
      <>
      <div id = "auto">
        <div className="app">
          <button className="backButton" onClick = {() => navigate('/telushelper')}>
            Back to Menu
          </button>
          <div className="labels">
            <h2 className="autotitleLabel">Autocomplete</h2>
            <h1 className="earningsValue">Earnings: {`$${Math.max(total[0],0).toFixed(3)}`}</h1>
            <button className="clear" onClick={clear}>
              Clear
            </button>
          </div>
  
          <div className = "autotimes0">
            {renderTimes()}
          </div>
          <div className = "autotimes1">
            {renderTimes2()}
          </div>
          <h4 className = "lastRowLabel">
            <h4 className = "autolastLabel">{time[12].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}
            </h4>
          </h4>
          
          <div className='task-controls0'>
              {renderTaskControls()}
          </div>  
        
          <div className ="searchtask-controls1">
            {renderTaskControls2()}
          </div>
          <div id = "searchTimer">
            {Timer()}
          </div>
        </div>
      </div>
      </>
    );
  };
  
  
  
