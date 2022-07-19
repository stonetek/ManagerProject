import { BrowserRouter, Route, Routes } from "react-router-dom";
import Developer from "./pages/developer/Developers";
import Home from "./pages/home/Home";


function Routers () {
    return (
        <BrowserRouter>
            <Routes>
            <Route path='/' element={<Home/>} />
            <Route path='/developer' element={<Developer/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Routers;