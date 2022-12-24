import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';

import './App.css';
import Airports from './components/Airports/Airports';
import Flights from './components/Flights/Flights';

function App() {
  return (
    <Router>
      <Navbar />
      <div className='App'>
        <Routes>
          <Route path="/"  element={<Home />}/>
          <Route path="/airports" element={<Airports />}/>
          <Route path="/flights" element={<Flights />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
