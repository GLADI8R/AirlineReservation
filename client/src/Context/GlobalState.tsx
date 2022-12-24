import { createContext, useReducer } from "react";
import AppReducer from "./AppReducer";
import axios from 'axios';


const initState:any = {
    error: null,
    loading: true,
    airports: [],
    allFlights: []
};

export const GlobalContext = createContext(initState);

export const GlobalProvider = (props: { children: any }) => {
    const [state, dispatch] = useReducer(AppReducer, initState);

    async function getAllAirports () {
        try {
            const res = await axios.get('http://localhost:8080/v1/api/getAirports');
            // console.log(res.data);
            dispatch({
                type: 'GET_AIRPORTS',
                payload: res.data
            });

        } catch (err: any) {
            dispatch({
                type: 'ERROR',
                payload: err.response.data.error
            });
        }
    }


    return (
        <GlobalContext.Provider value={{
            error: state.error,
            loading: state.loading,
            airports: state.airports,
            getAllAirports
        }}>
            {props.children}
        </GlobalContext.Provider>
    );
}