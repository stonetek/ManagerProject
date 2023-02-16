import './styles.css';
import { Link } from 'react-router-dom';
import { FcSearch,FcAdvance } from "react-icons/fc";
import DataTable from '../../components/Table';
import Header from '../../components/header/Header';
import DEV from '../../assets/img/dev.jpg';


function Developer(){
  return (
    <>

      <div className=" w-screen flex flex-row items-center">
        <Header/>
        <div className="w-2/4">
          <Link to={"/developer/new/0"} title='Add New Developer'>
            <img src={DEV} alt="Novo"  className='w-20 h-10 rounded-full'/>
          </Link>
        </div>
      </div>

      <div className="container">
        <div className="card">
          <div><Link to={'/'} className="text-center text-teal-700 " ><FcAdvance title='VOLTAR' 
            className='w-32 h-20 rotate-180 -mt-10 -ml-10 mb-10'/></Link>
          </div>

            <h2>DESENVOLVEDORES</h2>
              
              <div>                
                <div className="form-control-container">
                  <FcSearch className="mt-1 absolute w-9 h-10 ml-80"/>
                  <input className="form-control" type="text"/>
                  <span className="focus-input" data-placeholder="Search"></span>
                </div>
              </div>
            <DataTable/>
        </div>
      </div>
    </>  
  );
}

export default Developer;