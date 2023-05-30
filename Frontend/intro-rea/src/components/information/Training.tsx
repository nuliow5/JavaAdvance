import {useState} from "react";

const Training = () => {
    const [likes, setLikes] = useState(0);
    const [inputValue, setInputValue] = useState('');

    function increment() {
        setLikes(likes + 1)
    }

    function decrement() {
        setLikes(likes - 1)
    }

    function showInput(event: any) {
        setInputValue(event.target.value);
    }

    return (
        <>
            <div className={'training'}>
                <div>
                    <strong>FIRST TASK</strong>
                    <p>count likes:</p>
                    <h1>{likes}</h1>
                    <div>
                        <button onClick={increment}>+</button>
                        <button onClick={decrement}>-</button>
                    </div>
                </div>
                <div>
                    <strong>SECOND TASK</strong>
                    <h1>{inputValue}</h1>
                    <input type='text' value={inputValue} onChange={showInput}/>
                </div>
            </div>
        </>
    )
}

export default Training;