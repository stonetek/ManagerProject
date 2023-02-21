import { Link } from "react-router-dom";
import { BsTrash, BsPencil } from 'react-icons/bs';
import { BiSelection } from "react-icons/bi";
import { FcAdvance, FcSearch } from "react-icons/fc";
import { useEffect, useState } from "react";
import { fetchProjects } from "../../api";
import { Projects } from "../../types/Projects";
import { formatLocalDate } from "../../utils/format";
import './projects.css';  
import Header from "../../components/header/Header";
import PROJ from '../../assets/img/project.jpg';
import api from "../../services/api";


function Projecting(){

  
  const [projects, setProjects] = useState<Projects[]>([]);

  async function deleteProject(id: number) {
    try {
        await api.delete(`/api/projects/${id}`)

        setProjects(projects.filter(proj => proj.id !== id))
        alert('Delete Success!')
    } catch (error) {
        alert('Delete failed! Try again!')
    }
}
  
  useEffect(() => {
    fetchProjects().then(response => setProjects(response.data))
    .catch(error => console.log(error))        
    }, []);
    
  const [search, setSearch] = useState('');
  const lowerSearch = search.toLowerCase();
  const projectSearch = projects.filter((projects) => projects.clientName.toLowerCase().
  includes(lowerSearch));

  return (
    <>
      <div className='flex flex-row gap-10'>
          <Header/>
          <div className="w-2/4 mt-8">
                  <Link to={"/projectslist/new/0"} title='Add New Project'>
                    <img src={PROJ} alt="Novo"  className='w-20 h-10 rounded-full'/>
                  </Link>
                </div>
      </div>
      <div className='w-full -mt-20 ml-10'>
          <div className="card">

            <div className='gap-48 flex flex-row'>   
              <div className='flex flex-row gap-20'>
                <Link to={'/'} className="text-center text-teal-700 " >
                <FcAdvance title='VOLTAR' className='w-32 h-20 rotate-180 -mt-8'/></Link>
                <h2 className='w-12'>Projetos</h2>
              </div>
                  <div>                
                    <div className="form-control-container">
                      <input className="form-control" type="text" value={search} 
                      onChange={(event) => setSearch(event.target.value) } />
                      <FcSearch className="mt-1 w-9 h-10"/>
                      <span className="focus-input" data-placeholder="Search"></span>
                    </div>
                </div>
            </div>
            <div className='table'>
                <table className='projs'>
                  <thead>
                    <tr>
                      <td className="w-60">Nome do Projeto</td>
                      <td className="w-60">Nome do Cliente</td>
                      <td className="show-after992">Data de Inicio</td>
                      <td className="show-after992">Prazo</td>
                      <td className="show-after576">Orçamento</td>
                      <td className="show-after576">Ação</td>
                    </tr>
                  </thead>

                  <tbody>
                    { projectSearch.map(proj =>(
                          <tr key={proj.id}>
                          <td>{proj.projectName}</td>
                          <td>{proj.clientName}</td>
                          <td className="show-after992">{formatLocalDate(proj.date, "dd/MM/yyy")}</td>
                          <td className="show-after992">{proj.deadline}</td>
                          <td className="show-after576">R$ {proj.budget}</td>
                          <td className="show-after576">
                            <div className="flex items-center flex-row gap-1 w-52 h-12 ml-2">
                                  <button key={'del'} className="w-14 h-10 flex-col flex items-center" 
                                  title="EXCLUIR" onClick={() => deleteProject(proj.id)}>
                                    <BsTrash className="w-20 h-6 mt-2" color="red"/> 
                                  </button>
        
                                  <Link
                                    to={`/projectslist/${proj.id}`}
                                    className="w-14 h-10 flex-col flex items-center" 
                                    title="EDITAR">
                                      <BsPencil className="w-10 h-6 mt-2" color="yellow"/>
                                  </Link>  
        
                                  <button key={'vinc'} className="w-14 h-10 flex-col flex items-center" title="VINCULAR"> 
                                    <BiSelection className="w-20 h-6 mt-2" color="green"/>
                                  </button>
                                  
                              </div> 
                          </td>
                        </tr>
                    ))}
                  </tbody>
              </table>
            </div>
        </div>
      </div>  
      </>
  );
  
}

export default Projecting;