


const FlightCard = (props: {flight: any}) => {

    return(
        <span>{props.flight.join(", ")}</span>
    );
}

export default FlightCard;