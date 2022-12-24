

const Flight = (props: {route_id: Number, fare: Number, seats_left: Number, dept_code: String, arr_code: String, dept_date: any, dept_time: any, arr_time: any}) => {

    return (
        <li>
            <span>{props.route_id}    {props.fare}    {props.seats_left}    {props.dept_code}    {props.arr_code}    {props.dept_date}    {props.dept_time}    {props.arr_time}</span>
        </li>
    );
}

export default Flight;