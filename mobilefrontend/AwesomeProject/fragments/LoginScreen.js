import {Button, SafeAreaView, Text, TextInput} from "react-native";
import {useContext, useState} from "react";
import {LoginRequest} from "../request/authentication/loginrequest";
import {UserContext} from "../App";

const LoginScreen = ({navigation}) => {
    const [name, setName] = useState();
    const [error, setError] = useState();
    const [password, setPassword] = useState();
    const {user, setUser} = useContext(UserContext);
    return (
        <SafeAreaView>
            <Text>Login</Text>
            <TextInput
                keyboardType="default"
                onChangeText={setName}
            />
            <Text>Password</Text>
            <TextInput
                keyboardType="default"
                textContentType={"password"}
                secureTextEntry={true}
                onChangeText={setPassword}
            />
            <Button
                title="Login"
                onPress={() => {
                    LoginRequest(setUser, setError, name, password);
                }}
            />
            {error && <Text>Could not login. Try again!</Text>}
        </SafeAreaView>

    );
};
export default LoginScreen;
