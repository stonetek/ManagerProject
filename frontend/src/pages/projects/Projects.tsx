import { Link } from "react-router-dom";
import SETA from '../../assets/img/seta.jpg';
import { BsTrash, BsPencil } from 'react-icons/bs';
import { BiSelection } from "react-icons/bi";
import { FcSearch } from "react-icons/fc";
import { useEffect } from "react";
import axios from "axios";



function Projects(){

  useEffect(() => {
    axios.get("localhost:8080/projects")
      .then(response => {
        console.log(response.data);
      });  
    }, []);
  

  return (
    <div className="container">
        <div className="card">
        <div className='container-link'>
        <Link to={"/"}><img src={SETA} alt="voltar"/></Link>
        </div>
            <h2>Projetos</h2>
              <div>                
                <div className="form-control-container">
                  <FcSearch className="mt-1 absolute w-9 h-10 ml-80"/>
                  <input className="form-control" type="text"/>
              </div>
            </div>
          <div className='table'>
            <table className='devs'>
              <thead>
                <tr>
                  <td className="show-after576">Id</td>
                  <td>Nome do Projeto</td>
                  <td>Nome do Cliente</td>
                  <td className="show-after992">Data de Inicio</td>
                  <td className="show-after992">Prazo</td>
                  <td className="show-after576">Orçamento</td>
                  <td className="show-after576">Ação</td>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td className="show-after576">#284</td>
                  <td>Streamer Games</td>
                  <td>Akemy Phanda</td>
                  <td className="show-after992">21/02/2001</td>
                  <td className="show-after992">6 meses</td>
                  <td className="show-after576">R$ 8.000,00</td>
                  <td className="show-after576">
                    <div className="flex items-center flex-row gap-16 w-56 h-12 ml-16">
                          <button className="w-3 flex-col flex items-center">
                            <BsTrash className="w-20 h-6 "/> 
                            <p className="font-semibold text-sm" >Excluir</p>
                          </button>

                          <button className="w-3 flex-col flex items-center">
                            <BsPencil className="w-20 h-6"/>
                            <p className="font-semibold text-sm" >Editar</p>
                          </button> 

                          <button className="w-3 flex-col flex items-center"> 
                            <BiSelection className="w-20 h-6"/>
                            <p className="font-semibold text-sm" >Vínculo</p>
                          </button>
                      </div> 
                  </td>
                </tr>

                <tr>
                <td className="show-after576">#284</td>
                  <td>Streamer Games</td>
                  <td>Akemy Phanda</td>
                  <td className="show-after992">21/02/2001</td>
                  <td className="show-after992">6 meses</td>
                  <td className="show-after576">R$ 8.000,00</td>
                  <td className="show-after576">
                    <div className="flex items-center flex-row gap-16 w-56 h-12 ml-16">
                          <button className="w-3 flex-col flex items-center">
                            <BsTrash className="w-20 h-6 "/> 
                            <p className="font-semibold text-sm" >Excluir</p>
                          </button>

                          <button className="w-3 flex-col flex items-center">
                            <BsPencil className="w-20 h-6"/>
                            <p className="font-semibold text-sm" >Editar</p>
                          </button> 

                          <button className="w-3 flex-col flex items-center"> 
                            <BiSelection className="w-20 h-6"/>
                            <p className="font-semibold text-sm" >Vínculo</p>
                          </button>
                      </div> 
                  </td>
                </tr>

                <tr>
                  <td className="show-after576">#284</td>
                  <td>Streamer Games</td>
                  <td>Akemy Phanda</td>
                  <td className="show-after992">21/02/2001</td>
                  <td className="show-after992">6 meses</td>
                  <td className="show-after576">R$ 8.000,00</td>
                  <td className="show-after576">
                    <div className="flex items-center flex-row gap-16 w-56 h-12 ml-16">
                          <button className="w-3 flex-col flex items-center" onClick={() => {
                            alert('excluído')
                          }}>
                            <BsTrash className="w-20 h-6 "/> 
                            <p className="font-semibold text-sm" >Excluir</p>
                          </button>

                          <button className="w-3 flex-col flex items-center">
                            <BsPencil className="w-20 h-6"/>
                            <p className="font-semibold text-sm" >Editar</p>
                          </button> 

                          <button className="w-3 flex-col flex items-center"> 
                            <BiSelection className="w-20 h-6"/>
                            <p className="font-semibold text-sm" >Vínculo</p>
                          </button>
                      </div> 
                  </td>
                </tr>

              </tbody>
            </table>
          </div>
        </div>
      </div>  
  );
}

export default Projects;