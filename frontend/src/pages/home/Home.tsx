import { Link } from 'react-router-dom';
import Header from  '../../components/header/Header';
import './styles.css';
import DEV from '../../assets/img/dev.jpg';
import PROJ from '../../assets/img/project.jpg';

function Home() {
  return (
    <>
      <Header />
      <div className='flex items-center flex-col justify-items-center '>
          <div className='flex items-center mt-20 mb-5'>
            <Link to={"/developer"} >DESENVOLVEDORES 
              <img src={DEV} alt="" className='w-22 h-10 rounded-full ml-8'/>
            </Link>
          </div>

          <div className='flex items-center mt-4 mb-5'>
            <Link to={"/projects"}>PROJETOS 
              <img src={PROJ} alt="" className='w-28 h-10 rounded-full -ml-2'/>
            </Link>
          </div>

          <div className='flex items-center mt-4 mb-5'>
            <Link to={"/projectslist"}>LISTA DE PROJETOS 
              <img src={PROJ} alt=""  className='w-28 h-10 rounded-full ml-3'/>
            </Link>
          </div>
      </div>
    </>   
  )
}

export default Home;
