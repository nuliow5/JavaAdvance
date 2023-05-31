import Header from "../components/view/Header";
import Footer from "../components/view/Footer";
import "../style/style.css";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import AboutMe from "../components/information/AboutMe";
import Contacts from "../components/information/Contacts";
import Cart from "../components/information/Cart";
import MyForm from "../components/information/MyForm";
import Nav from "../components/view/Nav";
import Training from "../components/information/Training";
import Pets from "../components/information/Pets";


function App() {

    return (
        <BrowserRouter>
            <div id={'page-container'}>
                <Header/>
                {/*<Section/>*/}

                <Routes>
                    <Route path="/aboutMe" element={<AboutMe/>}/>
                    <Route path="/contacts" element={<Contacts/>}/>
                    <Route path="/card" element={<Cart/>}/>
                    <Route path="/myForm" element={<MyForm/>}/>
                    <Route path="/training" element={<Training/>}/>
                    <Route path="/pets" element={<Pets/>}/>
                </Routes>
                <Footer/>
            </div>
        </BrowserRouter>

    );

}

export default App;
