import LOGO from '../../assets/img/logo.jpg'; 

function Header(){
  return ( 
    <div className="bg-gradient-to-r from-slate-700 w-screen h-28">
      <div className="-mt-4 flex row-span-1">
        <img src={LOGO} alt="logo" className='w-20 h-20 ml-5 rounded-2xl mt-6'/>
        <div>
        <h1 className='mt-8 ml-2'>Manager Project</h1>
        <p className='mt-2 ml-2' >
            Desenvolvido por
            <a href="https://www.instagram.com/pedrors99999/" target={'_blank'} className='text-green-400'> Pedro Paulo</a>
        </p>
        </div>
      </div>
    </div>
)

}

export default Header;