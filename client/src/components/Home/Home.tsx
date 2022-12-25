import { Fragment, useContext } from "react";
import { GlobalContext } from "../../Context/GlobalState";


const Home = () => {
    const {name} = useContext(GlobalContext);
    
    return(
        <Fragment>
            <h1>Home</h1>
            <h2>Hi {name}!</h2>
        </Fragment>       
    );
}

export default Home;