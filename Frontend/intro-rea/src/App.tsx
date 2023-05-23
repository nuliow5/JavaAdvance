import React from 'react';
import logo from './logo.svg';
import './App.css';
import Welcome from "./components/Welcome";
import Button from "./components/Button";

function App() {
  return (
    <div>
      <Welcome name={'Petras'} surname={'Petraitis'}/>
      <Button/>
    </div>
  );
}

export default App;
