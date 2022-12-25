import { Fragment } from "react";
import { Link } from "react-router-dom";


const Navbar = () => {
    return(
        <Fragment>
            <nav>
                <ul>
                    <li><Link to="/airports">Airports</Link></li>
                    <li><Link to="/flights">Flights</Link></li>
                    <li><Link to="/login">Login</Link></li>
                </ul>
            </nav>
        </Fragment>
    );
}

export default Navbar;