function Button(){

    return <button onClick={shoot}>Take the shot!</button>
}

const shoot = () => {
    alert("Great Shot!");
}
export default Button;