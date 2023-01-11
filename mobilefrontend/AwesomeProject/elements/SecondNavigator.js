import ParcelScreen from "../fragments/ParcelScreen";
import * as React from "react";
import MainScreen from "../fragments/MainScreen";


export const MainView = ({Stack}) => {
    return (
        <Stack.Navigator>
            <Stack.Screen name="Main" component={MainScreen}/>
            <Stack.Screen name="ParcelScreen" component={ParcelScreen}/>
        </Stack.Navigator>);
};
