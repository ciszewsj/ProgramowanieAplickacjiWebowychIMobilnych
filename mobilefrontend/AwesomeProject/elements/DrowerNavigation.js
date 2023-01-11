import HomeScreen from "../fragments/MainScreen";
import LoginScreen from "../fragments/LoginScreen";
import * as React from "react";
import {useContext} from "react";
import {UserContext} from "../App";
import RegisterScreen from "../fragments/RegisterScreen";
import CreateParcelScreen from "../fragments/CreateParcelScreen";
import ParcelsScreen from "../fragments/ParcelsScreen";
import AdminScreen from "../fragments/AdminScreen";
import LogoutScreen from "../fragments/LogoutScreen";


let Nav = ({Drawer}) => {
    const {user} = useContext(UserContext);

    return (
        <Drawer.Navigator initialRouteName="Main">
            <Drawer.Screen name="Main" component={HomeScreen}/>
            <Drawer.Screen name="Create Parcel" component={CreateParcelScreen}/>
            {user && user.token && user.token !== "" ?
                <>
                    <Drawer.Screen name="My parcels" component={ParcelsScreen}/>
                    {user.role === "ROLE_admin" &&
                        <Drawer.Screen name="Admin" component={AdminScreen}/>
                    }
                    <Drawer.Screen name="Logout" component={LogoutScreen}/>
                </>
                :
                <>
                    <Drawer.Screen name="Login" component={LoginScreen}/>
                    <Drawer.Screen name="Register" component={RegisterScreen}/>
                </>
            }

        </Drawer.Navigator>
    );
}
export default Nav;
