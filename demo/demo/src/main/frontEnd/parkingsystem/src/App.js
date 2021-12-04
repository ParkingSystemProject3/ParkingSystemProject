import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './components/Home'
import Login  from './components/LogIn'
function App() {
  return (
    <BrowserRouter>
    
    <div className="App">
      
    <Routes>
     <Route exact path="/" element={<Login />} />
     <Route path="/home" element={<  Home/>} />
      </Routes>

</div>
    </BrowserRouter>
       
    
  );
}

export default App;
