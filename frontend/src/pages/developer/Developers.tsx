import './styles.css';
import SETA from '../../assets/img/seta.jpg';
import { Link } from 'react-router-dom';
import { FcSearch } from "react-icons/fc";
import DataTable from '../../components/Table';



function Developer(){
  return (
      <div className="container">
        <div className="card">
          <div className='-mt-4 w-12'>
            <Link to={"/"}><img src={SETA} alt="voltar" title='VOLTAR' className='h-14 w-10 mb-7'/></Link>
          </div>
            <h2>DESENVOLVEDORES</h2>
            <div>      
              <div className="form-control-container">
                <FcSearch className="mt-1 absolute w-9 h-10 ml-80"/>
                <input className="form-control" type="text" />
              </div>
            </div>
            <DataTable/>
        </div>
      </div>  
  );
}

export default Developer;