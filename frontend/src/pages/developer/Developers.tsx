import './styles.css';
import SETA from '../../assets/img/seta.jpg';
import { Link } from 'react-router-dom';
import { BsPencil, BsTrash } from 'react-icons/bs';
import { BiSelection } from 'react-icons/bi';
import { FcSearch } from "react-icons/fc";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { Developers } from '../../types/Developer';
import { fetchDevelopers } from '../../api';


function Developer(){

  const [developers, setDevelopers] = useState<Developers[]>([]);
  console.log(developers);

  useEffect(() => {
  fetchDevelopers().then(response => setDevelopers(response.data))
  .catch(error => console.log(error))
  }, []);



  return (
      <div className="container">
        <div className="card">
        <div className='container-link'>
        <Link to={"/"}><img src={SETA} alt="voltar" /></Link>
        </div>
          <h2>DESENVOLVEDORES</h2>
          <div>
                        
             <div className="form-control-container">
             <FcSearch className="mt-1 absolute w-9 h-10 ml-80"/>
              <input className="form-control" type="text" />
            </div>


          </div>
          <div className='table'>
            <table className='devs'>
              <thead>
                <tr>
                  <td className="show-after576">Id</td>
                  <td>Nome</td>
                  <td>E-mail</td>
                  <td className="show-after992">Data de nascimento</td>
                  <td className="show-after992">Salario</td>
                  <td className="show-after576">Carga horaria</td>
                  <td className="show-after992">Ação</td>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td className="show-after576">#555</td>
                  <td>Pedro Paulo</td>
                  <td>pedropaulo@gmail.com</td>
                  <td className="show-after992">31/05/1977</td>
                  <td className="show-after992">R$ 5.000,00</td>
                  <td className="show-after576">8hs</td>
                  <td className="show-after576">
                      <div className="flex items-center gap-8">
                        <button className="w-3">
                          <BsTrash className="w-20 h-6"/>
                        </button>

                        <button className="w-3">
                          <BsPencil className="w-20 h-6"/>
                        </button> 

                        <button className="w-3"> 
                          <BiSelection className="w-20 h-6"/>
                        </button>
                      </div> 
                  </td>
                </tr>

                <tr>
                  <td className="show-after576">#555</td>
                  <td>Pedro Paulo</td>
                  <td>pedropaulo@gmail.com</td>
                  <td className="show-after992">31/05/1977</td>
                  <td className="show-after992">R$ 5.000,00</td>
                  <td className="show-after576">8hs</td>
                  <td className="show-after576">
                  <div className="flex items-center gap-8">
                        <button className="w-3">
                          <BsTrash className="w-20 h-6"/>
                        </button>

                        <button className="w-3">
                          <BsPencil className="w-20 h-6"/>
                        </button> 

                        <button className="w-3"> 
                          <BiSelection className="w-20 h-6"/>
                        </button>
                      </div> 
                  </td>
                </tr>

                <tr>
                  <td className="show-after576">#555</td>
                  <td>Pedro Paulo</td>
                  <td>pedropaulo@gmail.com</td>
                  <td className="show-after992">31/05/1977</td>
                  <td className="show-after992">R$ 5.000,00</td>
                  <td className="show-after576">8hs</td>
                  <td className="show-after576">
                  <div className="flex items-center gap-8">
                        <button className="w-3">
                          <BsTrash className="w-20 h-6"/>
                        </button>

                        <button className="w-3">
                          <BsPencil className="w-20 h-6"/>
                        </button> 

                        <button className="w-3"> 
                          <BiSelection className="w-20 h-6"/>
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

export default Developer;