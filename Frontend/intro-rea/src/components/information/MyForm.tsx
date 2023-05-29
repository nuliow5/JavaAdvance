import {useState} from "react";

const MyForm = () => {
    const [visible, setVisible] = useState(false);

    const [button, setActive] = useState(false);
    const submit = (e: any) => {
        e.preventDefault()

        console.log(e.target[0].name);

        setProduct({
            ...product,
            [e.target[0].name]: e.target[0].value,
            [e.target[1].name]: e.target[1].value,
            [e.target[2].name]: e.target[2].value,
            [e.target[3].name]: e.target[3].value,
        });
        setVisible(true);
    }

    const onChangeEvent = (event: any) => {
        setProduct({
            ...product,
            [event.target.name]: event.target.value
        });
        setVisible(true);
    }

    //my button
    const [disabled, setDisabled] = useState(true);
    const onInput = (event: any) => {
        setDisabled(false);

        setButtonValue({
            ...myButtonValue,
            [event.target.name]: event.target.value
        });

        if (myButtonValue.inputTest.length >= 10){
            setDisabled(true);
        }

    }

    const [myButtonValue, setButtonValue] = useState({
        inputTest: ''
    });


    // hookas
    const [product, setProduct] = useState({
        name: '',
        lastName: '',
        age: '',
        city: ''
    });


    return (
        <>
            <form onSubmit={submit} onChange={onChangeEvent}>

                <label htmlFor="fname">First name:</label><br/>
                <input
                    name="name"
                    type="name"
                    onChange={onChangeEvent}
                /><br/>
                <label htmlFor="lname">First name:</label><br/>
                <input
                    name="lastName"
                    type="lastName"
                /><br/>
                <label htmlFor="fage">Age:</label><br/>
                <input
                    name="age"
                    type="age"
                /><br/>
                <label htmlFor="fcity">City:</label><br/>
                <input
                    name="city"
                    type="city"
                /><br/>
                <button>Submit</button>
            </form>
            {
                visible &&
                <div>
                    <hr/>
                    <div>
                        Created product:
                        <div>Name: <strong>{product.name}</strong></div>
                        <div>Last name: <strong>{product.lastName}</strong></div>
                        <div>age: <strong>{product.age}</strong></div>
                        <div>City: <strong>{product.city}</strong></div>
                    </div>
                </div>
            }

            <div className={"inputAction"}>
                <form onChange={onInput}>
                    <label htmlFor="inputTest">Input:</label><br/>
                    <input
                        name="inputTest"
                        type="inputTest"
                    /><br/>
                    <button className={"myButton"} disabled={disabled} onClick={onInput}>Submit</button>
                </form>
            </div>


        </>
    );
}

export default MyForm;