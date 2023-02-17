import { useEffect, useState } from "react";
import { BiSend } from "react-icons/bi";
import { FcAdvance } from "react-icons/fc";
import { Link, useNavigate, useParams } from "react-router-dom";
import Header from "../../components/header/Header";
import api from "../../services/api";

function NewDeveloper() {

    const [ id, setId] = useState(null);
    const [ developerName, setDeveloperName] = useState('');
    const [ email, setEmail] = useState('');
    const [ birthdate, setBirthdate] = useState('');
    const [salary, setSalary] = useState('');
    const [ workload, setWorkload] = useState('');

    const {developerID} = useParams();

    const history = useNavigate();

    async function loadDeveloper() {
        try {
            const response = await api.get(`/api/developers/${developerID}`)
            
            let adjustedDate = response.data.date.split("T", 10)[0];
            setId(response.data.id);
            setDeveloperName(response.data.developerName);
            setEmail(response.data.email);
            setBirthdate(adjustedDate);
            setSalary(response.data.salary);
            setWorkload(response.data.workload);
        } catch (error) {
            alert('Error recovering developer" Try again!');
            history('/developer')
        }
    }

    useEffect(() => {
        if (developerID === "0") return;
        else loadDeveloper();
    }, [developerID])

    async function saveOrUpdate(e:{ preventDefault: () => void; }) {
        e.preventDefault();

        const data = {
            developerName,
            email,
            birthdate,
            salary,
            workload,
        }

        try {
            if (developerID === '0') {
                await api.post('/api/developers', data,{
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
            } else {
                data.id = id;
                await api.put(`/api/developers/${developerID}`, data, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
            }
            history('/developer')
        } catch (error) {
            alert('Error while recording developer Try again!')
        }
    }

    return(
        <>
        <Header/>
        <div><Link to={'/developer'} className="text-center text-teal-700 " ><FcAdvance title='VOLTAR' className='w-32 h-20 rotate-180'/></Link></div>
        <div className="w-screen h-screen bg-gradient-to-t from-slate-700 flex flex-col justify-center items-center mt-10 ">
              <h1 className="text-5xl mb-10">{developerID === '0' ? "'Add'" : "'Update'"} developer</h1>  
            <form 
                key={developerID}
                onSubmit={saveOrUpdate}
                className="bg-gradient-to-t from-zinc-300 w-3/6 h-3/4 
                flex flex-col items-center justify-center">
                <label htmlFor="Nome" className="text-2xl text-rose-800" >Nome do Desenvolvedor</label>
                <input type="text"
                value={developerName}
                onChange={e => setDeveloperName(e.target.value)} 
                className="w-60 text-black bg-red-400" />
                
                <label htmlFor="Email" className="text-2xl text-rose-800">Email</label>
                <input type="text"
                value={email}
                onChange={e => setEmail(e.target.value)} 
                className="w-60 bg-red-400" />
                
                <label htmlFor="Data" className="text-2xl text-rose-800">Aniversário</label>
                <input type="date"
                value={birthdate}
                onChange={e => setBirthdate(e.target.value)}    
                className="w-60 bg-red-400"/>
                
                <label htmlFor="Salario" className="text-2xl text-rose-800">Salario</label>
                <input type="text"
                value={salary}
                onChange={e => setSalary(e.target.value)}
                className="w-60 bg-red-400" />
                
                <label htmlFor="Hora" className="text-2xl text-rose-800">Horas Dia</label>
                <input type="text"
                value={workload}
                onChange={e => setWorkload(e.target.value)}  
                className="w-60 bg-red-400" />
                
                <button type="submit" onClick={saveOrUpdate} className="w-3/6 h-40 flex items-center justify-center" >
                    {developerID === 'id' ? "'Add'" : "'Update'"}
                    <BiSend title="Adicionar" color="green" className="w-1/4 h-1/4" />
                </button>
            </form>
        </div>
    </>
    )
}

export default NewDeveloper;