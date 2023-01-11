import * as React from 'react';
import {createDrawerNavigator} from '@react-navigation/drawer';
import {NavigationContainer} from '@react-navigation/native';
import Nav from "./elements/DrowerNavigation"

import {useState} from "react";
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import ParcelScreen from "./fragments/ParcelScreen";

const Drawer = createDrawerNavigator();
const Stack = createNativeStackNavigator();

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
