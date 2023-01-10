

const FlightCard = (props: {flight: any}) => {
    

    return(
        <span>
            {props.flight.dept_code}, {props.flight.arr_code}, {props.flight.dept_date}, {props.flight.dept_time} to {props.flight.arr_time}
            {/* {props.flight.join(", ")} */}
            <button>BOOK</button>
        </span>
    );
}

export default FlightCard;