import { BrowserRouter, Route, Routes } from "react-router-dom";
import Developer from "./pages/developer/Developers";
import Home from "./pages/home/Home";
import Projects from "./pages/projects/Projects";


function Routers () {
    return (
        <BrowserRouter>
            <Routes>
            <Route path='/' element={<Home/>} />
            <Route path='/developer' element={<Developer/>} />
            <Route path='/projects' element={<Projects/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Routers;