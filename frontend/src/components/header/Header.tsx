import LOGO from '../../assets/img/logo.jpg'; 
import './styles.css'

function Header(){
  return ( 
    <div className="bg-gradient-to-r from-slate-700 w-screen">
      <div className="logo-container">
        <img src={LOGO} alt="logo" className='mt-4'/>
        <h1 className='logo-title'>Manager Project</h1>
        <p className='logo-text'>
            Desenvolvido por
            <a href="https://www.instagram.com/pedrors99999/" target={'_blank'}> Pedro Paulo</a>
        </p>
      </div>
    </div>
)

}

export default Header;