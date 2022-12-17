import { useEffect, useState } from "react";
import { BiSelection } from "react-icons/bi";
import { BsPencil, BsTrash } from "react-icons/bs";
import { FcAdvance } from "react-icons/fc";
import { Link, useNavigate } from "react-router-dom";
import { fetchProjects} from "../../api";
import Header from "../../components/header/Header";
import { Projects } from "../../types/Projects";
import { formatLocalDate } from "../../utils/format";
import PROJ from '../../assets/img/project.jpg';
import api from "../../services/api";





function ProjectsList() {

    
  const [projects, setProjects] = useState<Projects[]>([]);
  const [page, setPage] = useState(0);

  const history = useNavigate();

  async function editProject(id:number) {
    try {
      history(`/projectslist/new/${id}`)
    } catch (error) {
      alert("Edit project failed! Try again!")
    }
  }

  async function deleteProject(id: number) {
    try {
        await api.delete(`projects/${id}`)

        setProjects(projects.filter(proj => proj.id !== id))
    } catch (error) {
        alert('Delete failed! Try again!')
    }
}

async function fetchMoreProjects() {
  const response = await api.get(`/projects`, {
    params: {
      page: page,
      limit: 4,
      direction: 'asc'
    }
  });

  setProjects([...projects, ...response.data])
  setPage(page +1)
}
  
  useEffect(() => {
    fetchMoreProjects()     
    }, []); 
  
    
    return (
        <>
            <div className=" w-screen flex flex-row items-center">
              <Header/>

              <div className="w-2/4">
                <Link to={"/projectslist/new/0"} title='Add New Project'>
                  <img src={PROJ} alt="Novo"  className='w-20 h-10 rounded-full'/>
                </Link>
              </div>
            </div>

            <div><Link to={'/'} className="text-center text-teal-700 " ><FcAdvance title='VOLTAR' className='w-32 h-20 rotate-180'/></Link></div>
            
            <div className='w-screen h-1/6 flex justify-center items-center'>
            <div className='w-1/2 h-1/2 grid grid-cols-2 gap-5'>
            {projects.map(proj =>(
                <div className="bg-white w-80 h-80 rounded-2xl mt-32 flex flex-col items-center mr-5 hover:bg-stone-400" key={proj.id}>
                    <h1 className="text-center text-teal-700">NOME</h1>
                    <h2 className="w-40 text-center text-zinc-700 text-base">{proj.projectName}</h2>
                    <h1 className="text-center text-teal-700">CLIENTE</h1>
                    <h2 className="w-w-40 text-center text-zinc-700">{proj.clientName}</h2>
                    <h1 className="text-center text-teal-700">DATA DE INÍCIO</h1>
                    <h2 className="w-w-40 text-center text-zinc-700">{formatLocalDate(proj.date, "dd/MM/yyyy")}</h2>
                    <h1 className="text-center text-teal-700">PRAZO</h1>
                    <h2 className="w-w-40 text-center text-zinc-700">{proj.deadline}</h2>
                    <h1 className="text-center text-teal-700">ORÇAMENTO</h1>
                    <h2 className="w-w-40 text-center text-cyan-600">R$ {proj.budget.toFixed(2)}</h2>

                    <div className="flex items-center flex-row gap-1 w-52 h-12 ml-2 mt-5">
                              <button onClick={() => deleteProject(proj.id)} className="w-14 h-10 flex-col flex items-center" 
                              title="EXCLUIR" >
                                <BsTrash className="w-10 h-6 mt-2" color="red"/> 
                              </button>
    
                              <button
                              onClick={() => editProject(proj.id)}
                              className="w-14 h-10 flex-col flex items-center" 
                              title="EDITAR">
                                <BsPencil className="w-10 h-6 mt-2" color="yellow"/>
                              </button> 
    
                              <button className="w-14 h-10 flex-col flex items-center" title="VINCULAR"> 
                                <BiSelection className="w-10 h-6 mt-2" color="green"/>
                              </button>
                              
                    </div>
                    
                </div>
                ))}
            </div>
            </div>
        </>
    )
 }

 export default ProjectsList;