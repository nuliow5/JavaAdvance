interface User{
    name : string;
    surname?: string; //? neprivalomas
}


function Welcome(props:User){
    return <div>Hello, {props.name} {props.surname}</div>
}

//can using function or lemda
const Welcome1 = () => {

    return <>Hello, Coder!</>
}

export default Welcome;