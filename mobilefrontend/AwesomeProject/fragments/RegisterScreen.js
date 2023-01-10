import {useContext, useState} from "react";
import {UserContext} from "../App";
import {Button, SafeAreaView, Text, TextInput} from "react-native";
import {RegisterRequest} from "../request/authentication/registerrequest";

const RegisterScreen = ({navigation}) => {
    const [fields, setFields] = useState({});
    const [errorFields, setErrorFields] = useState({});
    const [error, setError] = useState({});
    const {user, setUser} = useContext(UserContext);

    const requestRegister = () => {
        setErrorFields({});
        setError();
        if (fields.password && fields.repeatPassword !== fields.password) {
            setErrorFields(() => {
                    errorFields.repeatPassword = "Passwords in fields are different";
                    return {...errorFields};
                }
            )
        } else {
            RegisterRequest(fields, setErrorFields, setError);
        }
    }

    return (
        <SafeAreaView>
            <Text>Name</Text>
            <TextInput
                keyboardType="default"
                onChangeText={e => setFields(() => {
                    fields.name = e
                    return fields;
                })}
            />
            {errorFields.name &&
                <><Text>{errorFields.name}</Text></>}
            <Text>Email</Text>
            <TextInput
                keyboardType="default"
                textContentType={"password"}
                onChangeText={e => setFields(() => {
                    fields.email = e;
                    return fields;
                })}
            />
            {errorFields.email &&
                <><Text>{errorFields.email}</Text></>}
            <Text>Password</Text>
            <TextInput
                keyboardType="default"
                textContentType={"password"}
                secureTextEntry={true}
                onChangeText={e => setFields(() => {
                    fields.password = e;
                    console.log(fields.password)
                    return fields;
                })}
            />
            {errorFields.password &&
                <><Text>{errorFields.password}</Text></>}
            <Text>Repeat password</Text>
            <TextInput
                keyboardType="default"
                textContentType={"password"}
                secureTextEntry={true}
                onChangeText={e => setFields(() => {
                    fields.repeatPassword = e;
                    return fields;
                })}
            />
            {errorFields.repeatPassword &&
                <><Text>{errorFields.repeatPassword}</Text></>}
            <Button
                title="Register"
                onPress={requestRegister}
            />
            {error.status === 500 && <Text>User already exists</Text>}

            {error && <Text>Could not register. Try again!</Text>}
        </SafeAreaView>

    );
};
export default RegisterScreen;
