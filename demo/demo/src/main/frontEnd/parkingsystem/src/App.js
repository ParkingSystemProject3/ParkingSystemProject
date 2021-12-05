import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './components/Home'
import Login  from './components/LogIn'
import Entry from './components/Entry'
import Exit from './components/Exit'
function App() {
  return (
    <BrowserRouter>
    
    <div className="App">
      
    <Routes>
     <Route exact path="/" element={<Login/>} />
     <Route path="/home" element={<Home/>} />
     <Route path="/entry" element={<Entry/>} />
     <Route path="/exit" element={<Exit/>} />
    
      </Routes>

</div>
    </BrowserRouter>
       
    
  );
}

export default App;
