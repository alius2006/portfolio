import './styles/index.less';
import {BrowserRouter as Router} from "react-router-dom";
import Header from "./Layout/Header";
import Menu from "./Layout/Menu";
import RoutedPage from "./Layout/RoutedPage";
import Footer from "./Layout/Footer";

function App() {
    return (
        <Router>
            <div className="App">
                <div className="Header"><Header/></div>
                <div className="Main">
                    <div className="Menu"><Menu/></div>
                    <div className="RoutedPage"><RoutedPage/></div>
                </div>
                <div className="Footer"><Footer /></div>
            </div>
        </Router>
    );
}

export default App;
