import {Button, Text} from "react-native";
import {SafeAreaView, StyleSheet, TextInput} from "react-native";
import React from "react";
import {NavigationToParcel} from "../elements/SecondNavigator";
import {createNativeStackNavigator} from "@react-navigation/native-stack";
import ParcelScreen from "./ParcelScreen";

const MainScreen = ({navigation}) => {

    const Stack = createNativeStackNavigator();
    let Main = ({navigation}) => {
        const [parcelId, setParcelId] = React.useState();
        return (
            <SafeAreaView>
                <Text>Parcel id</Text>

                <TextInput
                    keyboardType="numeric"
                    onChangeText={e => setParcelId(e)}
                />
                <Button
                    title="Find parcel"
                    onPress={() => {
                        console.log(parcelId);
                        navigation.navigate({name: 'ParcelScreen', params: {parcelId: parcelId}})
                    }
                    }
                />
            </SafeAreaView>
        )
    }
    return (
        <Stack.Navigator>
            <Stack.Screen name="MainPage" component={Main}/>
            <Stack.Screen name="ParcelScreen" component={ParcelScreen}/>
        </Stack.Navigator>
    );


};


export default MainScreen;
