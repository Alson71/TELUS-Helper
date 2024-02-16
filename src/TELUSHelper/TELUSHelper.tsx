import {useNavigate} from 'react-router-dom'
import {useState,useEffect} from 'react'
import telus from '/src/assets/telus.jpeg'
import './TELUSHelper.css'




export default function TELUSHelper() {
  document.body.style.backgroundColor = "beige"
  document.body.style.margin = "0"
  document.body.style.placeItems = "center"
  document.body.style.minWidth = "100%"
  document.body.style.minHeight = "100vh"
  document.body.style.overflowX = "hidden"
  document.body.style.overflowY = "hidden"
  document.body.style.display = "flex"

  const navigate = useNavigate()
  var [total,setTotal] = useState<number[]>([0])

  useEffect(() => {
    const handleLoadAllValues = (_event: any, data: any) => {
      if (data.number) {
        setTotal(data.number);
      }
    };

    window.ipcRenderer.send('get-all-totalearnings');
    window.ipcRenderer.on('load-all-totalearnings', handleLoadAllValues);

    return () => {
      window.ipcRenderer.removeListener('load-all-totalearnings', handleLoadAllValues);
    };
  }, []);

  const clear = () =>{
    if(total[0] > 0){
    if(!confirm("Are you sure you want to clear?")) return;
    }
    setTotal([0]);
    window.ipcRenderer.send('clear-all');
  }
  return (
    <>
    <div id = "telushelper0">
      {/*Better Spacing*/}
      <br/><br/><br/><br/><br/><br/>
      <br/><br/><br/><br/>
      <div className ="container">
          <img src = {telus} alt = "TELUS Logo" id= "telus"/>
      <div>
          <h1 id = "pad"> Data Analyst Earnings Assistant </h1>
      </div>
      <div>
          <button className="tasksButton" id = "mosttasks0" onClick = {() => navigate('/mosttasks')}>Most Tasks</button>
          <button className = "tasksButton" id = "search0" onClick = {() => navigate('/search')}>Search 2.0</button>
          <button className="tasksButton" id = "auto0" onClick = {() => navigate('/auto')}>Autocomplete</button>
          <button className="tasksButton" id ="address0" onClick = {() => navigate('/address')}>Address Ver.</button>
      </div>
      <div>    
          <br/>
          <button id = "clear" onClick = {clear}> Clear All </button>
      </div>
      

          <h3 id = "earnings">Current Earnings: ${Math.max(total[0],0).toFixed(3)}</h3>

      </div> 
    </div>
    </>
  )
}









