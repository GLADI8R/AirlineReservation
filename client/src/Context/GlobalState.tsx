import { createContext, useReducer } from "react";
import AppReducer from "./AppReducer";
import axios from 'axios';


const initState: any = {
    user_id: null,
    name: null,
    email: null,
    password: null,
    mobile: null,
    admin: false,
    error: null,
    loading: true,
    airports: [],
    allFlights: [],
};

export const GlobalContext = createContext(initState);

export const GlobalProvider = (props: { children: any }) => {
    const [state, dispatch] = useReducer(AppReducer, initState);

    async function getAllAirports() {
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


    // Add Airport service
    async function addAirport(airport: Object) {
        const config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }

        try {
            const res = await axios.post('http://localhost:8080/v1/api/add', airport, config);

            dispatch({
                type: 'ADD_AIRPORT',
                payload: res.data.data
            });
        } catch (err: any) {
            dispatch({
                type: 'ERROR',
                payload: err.response.data.error
            });
        }
    }

    async function getAllFlights() {
        try {
            const res = await axios.get('http://localhost:8080/v1/api/allFlights');
            // console.log(res.data);
            dispatch({
                type: 'ALL_FLIGHTS',
                payload: res.data
            });

        } catch (err: any) {
            dispatch({
                type: 'ERROR',
                payload: err.response.data.error
            });
        }
    }

    async function loginUser(email: String, password: String) {
        console.log(email);
        try {
            const res = await axios.get('http://localhost:8080/v1/api/loginUser', { params: { email, password } });
            console.log(res);
            dispatch({
                type: 'LOGIN_USER',
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
            user_id: state.user_id,
            name: state.name,
            email: state.email,
            password: state.password,
            mobile: state.mobile,
            admin: state.admin,
            error: state.error,
            loading: state.loading,
            airports: state.airports,
            allFlights: state.allFlights,
            getAllAirports,
            addAirport,
            getAllFlights,
            loginUser
        }}>
            {props.children}
        </GlobalContext.Provider>
    );
}