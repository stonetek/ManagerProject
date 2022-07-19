import { Link } from 'react-router-dom';
import Header from  '../../components/header/Header';
import './styles.css'


function Home() {
  return (
    <> 
      <Header />
      <div className='link-container'>
      
          <Link to={"/developer"}>DESENVOLVEDORES</Link>
        
      </div>
   </>
  )
}

export default Home;
