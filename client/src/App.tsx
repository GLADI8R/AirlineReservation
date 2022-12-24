import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';

import './App.css';
import Airports from './components/Airports/AirportsList';
import Flights from './components/Flights/Flights';
import { GlobalProvider } from './Context/GlobalState';

function App() {
  return (
    <GlobalProvider>
      <Router>
        <Navbar />
        <div className='App'>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/airports" element={<Airports />} />
            <Route path="/flights" element={<Flights />} />
          </Routes>
        </div>
      </Router>
    </GlobalProvider> 
  );
}

export default App;
