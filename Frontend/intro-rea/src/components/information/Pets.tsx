import React, {useState} from 'react';
import axios from "axios";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import CardExample from "./CardExample";
import PostList from "./PostList";

const Pets = () => {

    const divElementName = 'currentPet';
    const apiKey = '';
    const REQUEST_URL = 'https://petstore.swagger.io/v2/pet/findByStatus?status=available';

    async function getPet() {
        const response = await axios.get(REQUEST_URL);
        console.log(response.data[0].name);
        setPost(response.data[0].name);
    }




    const [post, setPost] = useState('')

    return (
        <>
            <PostList posts={post}/>
            <button onChange={getPet}>reload</button>
        </>

    );
};

export default Pets;