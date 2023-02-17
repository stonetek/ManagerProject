import { useEffect, useState } from "react";
import { BiSend } from "react-icons/bi";
import { Link, useNavigate, useParams } from "react-router-dom";
import Header from "../../components/header/Header";
import api from "../../services/api";
import { FcAdvance } from "react-icons/fc";


function Newproject() {

    const [ id, setId] = useState(null);
    const [ projectName, setProjectName] = useState('');
    const [ clientName, setClientName] = useState('');
    const [ date, setDate] = useState('');
    const [deadline, setDeadline] = useState('');
    const [ budget, setBudget] = useState('');

    const {projectID} = useParams();

    const history = useNavigate();

    async function loadProject() {
        try {
            const response = await api.get(`/api/projects/${projectID}`)
            
            let adjustedDate = response.data.date.split("T", 10)[0];
            setId(response.data.id);
            setProjectName(response.data.projectName);
            setClientName(response.data.clientName);
            setDate(adjustedDate);
            setDeadline(response.data.deadline);
            setBudget(response.data.budget);
        } catch (error) {
            alert('Error recovering project" Try again!');
            history('/projectslist')
        }
    }

    useEffect(() => {
        if (projectID === "0") return;
        else loadProject();
    }, [projectID])

    async function saveOrUpdate(e:{ preventDefault: () => void; }) {
        e.preventDefault();

        const data = {
            projectName,
            clientName,
            date,
            deadline,
            budget,
        }

        try {
            if (projectID === '0') {
                await api.post('/api/projects', data,{
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
            } else {
                data.id = id;
                await api.put(`/api/projects/${projectID}`, data, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
            }

            
            projectID === 'id' ? history('/projects') : history('/projectslist')
        } catch (error) {
            alert('Error while recording project Try again!')
        }
    }




    return (
        <>
            <Header/>
            <div><Link to={'/projectslist'} className="text-center text-teal-700 " ><FcAdvance title='VOLTAR' className='w-32 h-20 rotate-180'/></Link></div>
            <div className="w-screen h-screen bg-gradient-to-t from-slate-700 flex flex-col justify-center items-center mt-10 ">
                  <h1 className="text-5xl mb-10">{projectID === '0' ? "'Add'" : "'Update'"} project</h1>  
                <form 
                    key={projectID}
                    onSubmit={saveOrUpdate}
                    className="bg-gradient-to-t from-zinc-300 w-3/6 h-3/4 
                    flex flex-col items-center justify-center">
                    <label htmlFor="Nome" className="text-2xl text-rose-800" >Nome do Projeto</label>
                    <input type="text"
                    value={projectName}
                    onChange={e => setProjectName(e.target.value)} 
                    className="w-60 text-black bg-red-400" />
                    
                    <label htmlFor="Cliente" className="text-2xl text-rose-800">Cliente</label>
                    <input type="text"
                    value={clientName}
                    onChange={e => setClientName(e.target.value)} 
                    className="w-60 bg-red-400" />
                    
                    <label htmlFor="Data" className="text-2xl text-rose-800">Data Início</label>
                    <input type="date"
                    value={date}
                    onChange={e => setDate(e.target.value)}    
                    className="w-60 bg-red-400"/>
                    
                    <label htmlFor="Prazo" className="text-2xl text-rose-800">Prazo</label>
                    <input type="text"
                    value={deadline}
                    onChange={e => setDeadline(e.target.value)}
                    className="w-60 bg-red-400" />
                    
                    <label htmlFor="Orçamento" className="text-2xl text-rose-800">Orçamento</label>
                    <input type="text"
                    value={budget}
                    onChange={e => setBudget(e.target.value)}  
                    className="w-60 bg-red-400" />
                    
                    <button type="submit" onClick={saveOrUpdate} className="w-3/6 h-40 flex items-center justify-center" >
                        {projectID === 'id' ? "'Add'" : "'Update'"}
                        <BiSend title="Adicionar" color="green" className="w-1/4 h-1/4" />
                    </button>
                </form>
            </div>
        </>
    )
}

export default Newproject;

function normalizeSplitter(value: any): string {
    throw new Error("Function not implemented.");
}
