import {HashRouter as Router, Routes, Route} from "react-router-dom"
import TELUSHelper from "./src/TELUSHelper/TELUSHelper"
import MostTasks from "./src/Most Tasks/MostTasks"
import Search from "./src/Search/Search"
import Auto from "./src/Auto/Auto"
import Address from "./src/Address/Address"

export default function App(){
    return (
        <div>
            <Router>
                <Routes>
                    <Route index element = {<TELUSHelper/>}/>
                    <Route path = "/telushelper" element= {<TELUSHelper/>}/>
                    <Route path = "/mosttasks" element = {<MostTasks/>}/>
                    <Route path = "/search" element = {<Search/>}/>
                    <Route path = "/auto" element = {<Auto/>}/>
                    <Route path = "/address" element = {<Address/>}/>        
                </Routes>
            </Router>
        </div>
    )
}