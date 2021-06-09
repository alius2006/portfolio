import {Link} from "react-router-dom";

function Menu() {
    return (
        <div>
            <Link to="/"><h3>Home</h3></Link>
            <Link to="/section1"><h3>Section 1</h3></Link>
            <Link to="/section2"><h3>Section 2</h3></Link>
        </div>
    );
}

export default Menu;
