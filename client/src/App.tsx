import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';

import './App.css';
import Airports from './components/Airports/AirportsList';
import Flights from './components/Flights/Flights';
import { GlobalProvider } from './Context/GlobalState';
import AddAirport from './components/Airports/AddAirport';

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
            <Route path="/addAirport" element={<AddAirport />} />
          </Routes>
        </div>
      </Router>
    </GlobalProvider> 
  );
}

export default App;
