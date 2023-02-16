import './styles.css';
import { BsPencil, BsTrash } from 'react-icons/bs';
import { BiSelection } from 'react-icons/bi';
import { useEffect, useState } from 'react';
import { Developers } from '../../types/Developer';
import { fetchDevelopers } from '../../api';
import { formatLocalDate } from '../../utils/format';
import { BASE_URL } from '../../utils/requests';
import { Link } from 'react-router-dom';

function DataTable() {

      
      const [developers, setDevelopers] = useState<Developers[]>([]);
    
      useEffect(() => {
        fetchDevelopers().then(response => setDevelopers(response.data))
        .catch(error => console.log(error))
      }, []);
      
      function deletedeveloper(id: any) {
        fetch(BASE_URL+`/api/developers/${id}`,{
          method:'DELETE',
            headers: {
                'content-type': 'application/json'
            },
        }).then(response => response.json())
        .then(data => {
          setDevelopers(developers.filter((developers: { id: any; }) => developers.id !== id))
        })
        .catch(err => console.log(err))
        }
    return (
        <div className='table'>
              <table className=''>
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
                  {developers.map(dev =>(
                    <tr key={dev.id}> 
                    <td>{dev.developerName}</td>
                    <td>{dev.email}</td>
                    <td className="show-after992">{formatLocalDate(dev.birthDate, "dd/MM/yyy")}</td>
                    <td className="show-after992">R$ {dev.salary.toFixed(2)}</td>
                    <td className="show-after576">{dev.workload}</td>
                    <td className="show-after576">
                    <div className="flex items-center flex-row gap-1 w-52 h-12 ml-2">
                            
                              <Link to={`/developer/${dev.id}`} 
                              className="w-14 h-10 flex-col flex items-center" title="EDITAR"> 
                                <BsPencil className="w-20 h-6 mt-2" color="yellow"/>
                              </Link> 

                              <button className="w-14 h-10 flex-col flex items-center" title="VINCULAR"> 
                                <BiSelection className="w-20 h-6 mt-2" color="green"/>
                              </button> 

                              <button className="w-14 h-10 flex-col flex items-center" 
                              title="EXCLUIR" onClick={deletedeveloper}>
                                <BsTrash className="w-20 h-6 mt-2" color="red"/> 
                              </button>
    
                          </div> 
                      </td>
                  </tr>
                  ))}
                </tbody>
              </table>
            </div>
    )
}

export default DataTable

function props(props: any) {
  throw new Error('Function not implemented.');
}
