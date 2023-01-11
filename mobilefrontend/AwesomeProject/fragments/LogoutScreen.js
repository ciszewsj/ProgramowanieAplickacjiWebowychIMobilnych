import {useContext, useState} from "react";
import {UserContext} from "../App";
import {Button, SafeAreaView, Text} from "react-native";

const LogoutScreen = ({navigation}) => {
    const {setUser} = useContext(UserContext);
    setUser({})
    return (
        <SafeAreaView>
            <Text>You are log out</Text>
            <Button title={"OK"} onPress={e => {
                navigation.navigate("Main")
            }}/>
        </SafeAreaView>
    );
};
export default LogoutScreen;
