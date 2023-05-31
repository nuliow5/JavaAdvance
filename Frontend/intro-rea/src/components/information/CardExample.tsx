import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

function CardExample(props:any) {
    return (
        <div className={"card"}>
           <div className={"post"}>
               <div className={"post__content"}>
                   {/*<strong>{props.post.id} {props.post.title}</strong>*/}
                   <div>
                       {props}
                   </div>
               </div>
           </div>
            <div className={"post__btns"}>
                <button>press me</button>
            </div>


        </div>
    );
}

export default CardExample;