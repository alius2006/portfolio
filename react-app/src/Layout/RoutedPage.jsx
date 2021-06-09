import {Route, Switch} from "react-router-dom";
import Section2 from "../Pages/Section2";
import Section1 from "../Pages/Section1";
import Home from "../Pages/Home";

function RoutedPage() {
    return (
        <Switch>
            <Route path="/section2">
                <Section2 />
            </Route>
            <Route path="/section1">
                <Section1 />
            </Route>
            <Route path="/">
                <Home />
            </Route>
        </Switch>
    );
}

export default RoutedPage;
