import { BrowserRouter, Route, Routes } from "react-router-dom";
import Developer from "./pages/developer/Developers";
import Home from "./pages/home/Home";
import NewProject from "./pages/newproject/NewProject";
import ProjectsList from "./pages/projects/projectlist";
import Projecting from "./pages/projects/Projects";
import NewDeveloper from "./pages/newdeveloper/NewDeveloper";
import Login from "./pages/login/Login";

function Routers () {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Login/>} />
                <Route path='/home' element={<Home/>} />
                <Route path='/developer' element={<Developer/>} />
                <Route path='/developer/:developerID' element={<NewDeveloper/>} />
                <Route path='/developer/new/:developerID' element={<NewDeveloper/>} />
                <Route path='/projects' element={<Projecting/>} />
                <Route path='/projectslist' element={<ProjectsList/>} />
                <Route path='/projectslist/:projectID' element={<NewProject/>} />
                <Route path='/projectslist/new/:projectID' element={<NewProject/>} />
            </Routes>
        </BrowserRouter>
    )
}

export default Routers;