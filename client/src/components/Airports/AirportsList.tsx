import { Fragment, useContext, useEffect } from "react";
import { GlobalContext } from "../../Context/GlobalState";
import Airport from "./Airport";


const Airports = () => {

    const { airports, getAllAirports } = useContext(GlobalContext);

    useEffect(() => {
        getAllAirports();
    }, []);
    
    return (
        <Fragment>
            <h1>Airports</h1>

            {/* displays results */}
            <ul>
                {airports.map((airport:any) => (
                    <Airport city={airport.city} country={airport.country} code_id={airport.code_id} /> 
                ))}
            </ul>


            <button>Add Airport</button>
        </Fragment>
    );
};

export default Airports;