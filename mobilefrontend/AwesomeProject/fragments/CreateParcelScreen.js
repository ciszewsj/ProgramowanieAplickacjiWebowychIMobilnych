import {useContext, useState} from "react";
import {UserContext} from "../App";
import {RegisterRequest} from "../request/authentication/registerrequest";
import {Button, SafeAreaView, ScrollView, Text, TextInput} from "react-native";
import {CreateParcelRequest} from "../request/parcel/createparcelrequest";

const CreateParcelScreen = ({navigation}) => {
    const [fields, setFields] = useState({});
    const [errorFields, setErrorFields] = useState({});
    const [error, setError] = useState({errorCode: "", errorMessage: "", createdParcelId: 0});
    const {user, setUser} = useContext(UserContext);
    let role = user.role;

    const createRequest = () => {
        CreateParcelRequest(fields, setErrorFields, setError, user.token);
    }

    return (
        <SafeAreaView>
            {user.token ? <>
                    <ScrollView>
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
                            onChangeText={e => setFields(() => {
                                fields.email = e;
                                return fields;
                            })}
                        />
                        {errorFields.email &&
                            <><Text>{errorFields.email}</Text></>}

                        <Text>Post code</Text>
                        <TextInput
                            keyboardType="numeric"
                            onChangeText={e => setFields(() => {
                                fields.postCode = e;
                                return fields;
                            })}
                        />
                        {errorFields.postCode &&
                            <><Text>{errorFields.postCode}</Text></>}

                        <Text>City</Text>
                        <TextInput
                            keyboardType="default"
                            onChangeText={e => setFields(() => {
                                fields.city = e;
                                return fields;
                            })}
                        />
                        {errorFields.city &&
                            <><Text>{errorFields.city}</Text></>}

                        <Text>Street</Text>
                        <TextInput
                            keyboardType="default"
                            onChangeText={e => setFields(() => {
                                fields.street = e;
                                return fields;
                            })}
                        />
                        {errorFields.street &&
                            <><Text>{errorFields.street}</Text></>}

                        <Text>House number</Text>
                        <TextInput
                            keyboardType="default"
                            onChangeText={e => setFields(() => {
                                fields.houseNumber = e;
                                return fields;
                            })}
                        />
                        {errorFields.houseNumber &&
                            <><Text>{errorFields.houseNumber}</Text></>}

                        <Button
                            title="Create parcel"
                            onPress={createRequest}
                        />

                        {error.status && <Text>Could not create parcel. Try again!</Text>}
                    </ScrollView>
                </> :
                <Text>Log in to create parcel</Text>}
        </SafeAreaView>

    );
};
export default CreateParcelScreen;
