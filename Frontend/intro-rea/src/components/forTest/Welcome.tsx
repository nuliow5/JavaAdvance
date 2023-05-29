interface User {
    name: string;
    surname?: string; //? neprivalomas
}


const Welcome = ({user,salary}: any) => {
    return (
        <>
            <div>
                Hello, {user.name} {user.surname}
            </div>
            <div>
                Your salary {salary}
            </div>
        </>
    )
}
//can using function or lemda

const Welcome1 = ({name, surname, age}: any) => {

    return <>Hello, {name} {surname} {age}!</>
}

export default Welcome;