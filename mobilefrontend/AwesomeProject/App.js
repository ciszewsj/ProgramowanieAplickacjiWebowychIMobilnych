import * as React from 'react';
import {createDrawerNavigator} from '@react-navigation/drawer';
import {NavigationContainer} from '@react-navigation/native';
import Nav from "./elements/DrowerNavigation"
import HomeScreen from "./fragments/MainScreen";

import NotificationsScreen from "./fragments/Profile";
import createStackNavigator from "@react-navigation/stack";
import {useState} from "react";

const Drawer = createDrawerNavigator();
export const UserContext = React.createContext({});

// const Stack = createStackNavigator();
export default function App() {
    const [user, setUser] = useState({});
    const value = {user, setUser};

    return (
        <UserContext.Provider value={value}>
            <NavigationContainer>
                <Nav Drawer={Drawer}/>
            </NavigationContainer>
        </UserContext.Provider>
    );
}
