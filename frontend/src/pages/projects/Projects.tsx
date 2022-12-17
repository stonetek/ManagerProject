import { Link } from "react-router-dom";
import { BsTrash, BsPencil } from 'react-icons/bs';
import { BiSelection } from "react-icons/bi";
import { FcAdvance, FcSearch } from "react-icons/fc";
import { useEffect, useState } from "react";
import { fetchDelDev, fetchProjects } from "../../api";
import { Projects } from "../../types/Projects";
import { formatLocalDate } from "../../utils/format";
import './projects.css';  


function Projecting(){

  
  const [projects, setProjects] = useState<Projects[]>([]);

  function deleteproject(id: any) {
    fetchDelDev().then(response => response.request(id))
    .then(id => {
        setProjects(projects.filter((project: { id: any; }) => project.id !== id))
    })
    .catch(err => console.log(err))
    }
  
  useEffect(() => {
    fetchProjects().then(response => setProjects(response.data))
    .catch(error => console.log(error))        
    }, []); 

  return (
    <>
    <div className="container">
        <div className="card">
        <div><Link to={'/'} className="text-center text-teal-700 " ><FcAdvance title='VOLTAR' className='w-32 h-20 rotate-180'/></Link></div>
            <h2>Projetos</h2>
              <div>                
                <div className="form-control-container">
                  <FcSearch className="mt-1 absolute w-9 h-10 ml-80"/>
                  <input className="form-control" type="text"/>
                  <span className="focus-input" data-placeholder="Search"></span>
              </div>
            </div>
          <div className='table'>
            <table className='devs'>
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
                { projects.map(proj =>(
                      <tr key={proj.id}>
                      <td>{proj.projectName}</td>
                      <td>{proj.clientName}</td>
                      <td className="show-after992">{formatLocalDate(proj.date, "dd/MM/yyy")}</td>
                      <td className="show-after992">{proj.deadline}</td>
                      <td className="show-after576">R$ {proj.budget}</td>
                      <td className="show-after576">
                        <div className="flex items-center flex-row gap-1 w-52 h-12 ml-2">
                              <button key={'del'} className="w-14 h-10 flex-col flex items-center" 
                              title="EXCLUIR" onClick={deleteproject}>
                                <BsTrash className="w-20 h-6 mt-2" color="red"/> 
                              </button>
    
                              <button key={'edit'} className="w-14 h-10 flex-col flex items-center" title="EDITAR">
                                <BsPencil className="w-20 h-6 mt-2" color="yellow"/>
                              </button> 
    
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