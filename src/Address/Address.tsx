import React, {useState,useEffect}  from 'react'
import {useNavigate} from 'react-router-dom'
import "./Address.css"

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

export default function Address() {
  document.body.style.backgroundColor = "rgb(212, 57, 220)"
  document.body.style.margin = "0"
  document.body.style.placeItems = "center"
  document.body.style.minWidth = "200vh"
  document.body.style.minHeight = "100vh"
  document.body.style.overflowX = "hidden"
  document.body.style.overflowY = "auto"
  document.body.style.display = "flex"

  var [total, setTotal] = useState<number[]>(new Array(1).fill(0));
  var [number, setNumber] = useState<number[]>(new Array(2).fill(0));

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

    window.ipcRenderer.send('get-all-address');
    window.ipcRenderer.on('load-all-address', handleLoadAllValues);
    window.ipcRenderer.send('get-all-totalearnings');
    window.ipcRenderer.on('load-all-totalearnings',handleLoadTotal);

    return () => {
      window.ipcRenderer.removeListener('load-all-address', handleLoadAllValues);
      window.ipcRenderer.removeListener('load-all-totalearnings', handleLoadTotal);
      
    };
  }, []);

  const updateTotal = (newValue: number) => {
    setTotal((prevTotal) => {
      const updatedTotal = prevTotal[0] + newValue;
      return [updatedTotal];
    });
  };

    const tasks = new Array(2);
    tasks[0] = 0.450;
    tasks[1] = 0.700;

    const time = new Array(2);
        time[0] = "2m\n15s";
        time[1] = "3m\n30s";
    
  
     const taskButtonClick = (index: number) => {
      setNumber((prevNumbers) => {
        const updatedNumbers = [...prevNumbers];
        updatedNumbers[index] += 1;
          
        
        window.ipcRenderer.send('update-address', { index, increment: 1, taskUpdate: tasks[index] });
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
        window.ipcRenderer.send('update-address', { index, increment: -1, taskUpdate: -tasks[index] });
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
       updateTotal(-(tasks[i]*number[i]));
       number[i] = 0;
       setNumber([...number])
      }
      window.ipcRenderer.send('clear-all-address');
      window.ipcRenderer.send('update-address', { index: 1, increment: 0, taskUpdate: -random});
      
    };
  
    const renderTimes = () =>{
      return [...Array(2)].map((_,i) =>(
          <div key={i}>
            <h4> {time[i].split('\n').map((line:string, idx:number) => <React.Fragment key={idx}>{line}<br /></React.Fragment>)}</h4>
          </div>
      ));
  };

    const renderTaskControls = () => {
      return [...Array(2)].map((_, i) => (
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
          <br/>
          <button className="minus" onClick={() => negativeButtonClick(i)}>
            -
          </button>
        </div>
      ));
    };
    
    return (
      <>
      <div id = "address">
        <div className="app">
          <div className="addresslabels">
            <button className="backButton" id = "back" onClick = {() => navigate('/telushelper')}>
              Back to Menu
            </button>
            <h2 className="addresstitleLabel">Address Verification</h2>
            <h1 className="addressearningsvalue">Earnings: {`$${Math.max(total[0],0).toFixed(3)}`}</h1>
            <button className="addressclear" onClick={clear}>
              Clear
            </button>
          </div>
          <div className = "addresstaskandtime">
            <div className="addresstimes0">
              {renderTimes()}
            </div>
            <div className='addresstask-controls0'>
                {renderTaskControls()}
            </div>  
          </div>
          <div id = "addressTimer">
            {Timer()}
          </div>
        </div>
      </div>
      </>
    );
  };
  