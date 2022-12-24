/* eslint-disable import/no-anonymous-default-export */

export default (state: any, action: { type: any; payload: any; }) => {
    switch (action.type) {

        case 'GET_AIRPORTS':
            return {
                ...state,
                airports: action.payload
            }


        case 'TRANSACTION_ERROR':
            return {
                ...state,
                error: action.payload
            }

        default:
            return state;
    }
}