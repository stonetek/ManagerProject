import './styles.css';
import SETA from '../../assets/img/seta.jpg';
import { Link } from 'react-router-dom';
import { FcSearch } from "react-icons/fc";
import { BsPencil, BsTrash } from 'react-icons/bs';
import { BiSelection } from 'react-icons/bi';
import DEV from '../../assets/img/dev.jpg';
import Header from '../../components/header/Header';
import { useEffect, useState } from 'react';
import { Developers } from '../../types/Developer';
import api from '../../services/api';
import { fetchDevelopers } from '../../api';
import { formatLocalDate } from '../../utils/format';


function Developer(){
  const [developers, setDevelopers] = useState<Developers[]>([]);

  async function deleteDeveloper(id: number) {
    try {
      await api.delete(`/api/developers/${id}`)

      setDevelopers(developers.filter(dev => dev.id !== id))
      alert('Delete Success!')
    } catch (error) {
      alert('Delete failed! Try again!')
  }
    }

  useEffect(() => {
    fetchDevelopers().then(response => setDevelopers(response.data))
    .catch(error => console.log(error))
  }, []);

  const [search, setSearch] = useState('');
  const lowerSearch = search.toLowerCase();
  const developerSearch = developers.filter((developers) => developers.
    developerName.toLowerCase().includes(lowerSearch));

  return (
      <>
      <div className='flex flex-row gap-10'>
        <Header/>
        <div className="w-2/4 mt-8">
                <Link to={"/developer/new/0"} title='Add New Developer'>
                  <img src={DEV} alt="Novo"  className='w-20 h-10 rounded-full'/>
                </Link>
              </div>
      </div>
      <div className='w-full -mt-20 ml-10'>
        <div className="card">
            <div className='gap-48 flex flex-row'>      
              
              <div className='flex flex-row gap-20'>
                <Link to={"/"}><img src={SETA} alt="voltar" title='VOLTAR' className='h-14 w-10 -mt-5'/></Link>
                <h2 className='w-12'>DESENVOLVEDORES</h2>
              </div>
              
              <div className="form-control-container">
                <input className="form-control" type="text" value={search}
                onChange={(event) => setSearch(event.target.value)} />
                <FcSearch className="mt-1 w-9 h-10"/>
              </div>
            
            </div>
            
            <div className='mt-7 w-3/4 ml-20'>
              <div className='table'>
              <table>
                <thead>
                  <tr>
                    <td className='w-60'>Nome</td>
                    <td className='w-80'>E-mail</td>
                    <td className="show-after992">Data de nascimento</td>
                    <td className="show-after992">Salario</td>
                    <td className="show-after576">Carga horaria diária</td>
                    <td className="show-after576">Ação</td>
                  </tr>
                </thead>

                <tbody>
                  {developerSearch.map(dev =>(
                    <tr key={dev.id}> 
                    <td>{dev.developerName}</td>
                    <td>{dev.email}</td>
                    <td className="show-after992">{formatLocalDate(dev.birthDate, "dd/MM/yyy")}</td>
                    <td className="show-after992">R$ {dev.salary.toFixed(2)}</td>
                    <td className="show-after576">{dev.workload}</td>
                    <td className="show-after576">
                    <div className="flex items-center flex-row gap-1 w-52 h-12 ml-2">
                              <button className="w-14 h-10 flex-col flex items-center" 
                              title="EXCLUIR" onClick={() => deleteDeveloper(dev.id)}>
                                <BsTrash className="w-20 h-6 mt-2" color="red"/> 
                              </button>

                              <Link to={`/developer/${dev.id}`}>
                              <button className="w-14 h-10 flex-col flex items-center" title="EDITAR">
                                <BsPencil className="w-20 h-6 mt-2" color="yellow"/>
                              </button> 
                              </Link>

                              <button className="w-14 h-10 flex-col flex items-center" title="VINCULAR"> 
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
      </div>
    </>  
  );
}

export default Developer;