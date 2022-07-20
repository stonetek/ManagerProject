import { Link } from 'react-router-dom';
import Header from  '../../components/header/Header';
import './styles.css';
import DEV from '../../assets/img/dev.jpg';
import PROJ from '../../assets/img/project.jpg';

function Home() {
  return (
    <> 
      <Header />
      <div className='link-container'>
        <Link to={"/developer"}>DESENVOLVEDORES 
          <img src={DEV} alt="" />
        </Link>
      </div>

      <div className='link-container2'>
        <Link to={"/projects"}>PROJETOS 
          <img src={PROJ} alt="" />
        </Link>
      </div>
   </>
  )
}

export default Home;
