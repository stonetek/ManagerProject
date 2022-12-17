import { BrowserRouter, Route, Routes } from "react-router-dom";
import Developer from "./pages/developer/Developers";
import Home from "./pages/home/Home";
import NewProject from "./pages/newproject/NewProject";
import ProjectsList from "./pages/projects/projectlist";
import Projecting from "./pages/projects/Projects";


function Routers () {
    return (
        <BrowserRouter>
            <Routes>
            <Route path='/' element={<Home/>} />
            <Route path='/developer' element={<Developer/>} />
            <Route path='/projects' element={<Projecting/>} />
            <Route path='/projectslist' element={<ProjectsList/>} />
            <Route path='/projectslist/new/:projectID' element={<NewProject/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Routers;