import { Link } from 'react-router-dom';
import Header from  '../../components/header/Header';
import './styles.css';
import DEV from '../../assets/img/dev.jpg';
import PROJ from '../../assets/img/project.jpg';
//import { CgLogIn } from "react-icons/cg";

function Home() {
  return (
    <>
      <Header />
      <div className='flex items-center flex-col justify-items-center '>
          <h2 className='mt-20'>DESENVOLVEDORES</h2>
          <div className='flex items-center mb-5'>
            <Link to={"/developer"} > 
              <img src={DEV} title="Tabela" className='w-20 h-12 rounded-full'/>
            </Link>
          </div>

          <h2>PROJETOS</h2>
          <div className='flex items-center mt-4 mb-5'>
            <Link to={"/projects"}> 
              <img src={PROJ} title="Tabela" className='w-28 h-10 rounded-full'/>
            </Link>
          </div>

            <h2>PROJETOS</h2>
          <div className='flex items-center mt-4'>
            <Link to={"/projectslist"}> 
              <img src={PROJ} title="Cards"  className='w-28 h-10 rounded-full'/>
            </Link>
          </div>
      </div>
    </>   
  )
}

export default Home;
