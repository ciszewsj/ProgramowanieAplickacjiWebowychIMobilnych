import {Button, ScrollView, Text} from "react-native";
import {SafeAreaView, StyleSheet, TextInput} from "react-native";
import React, {useContext, useEffect, useState} from "react";
import {UserContext} from "../App";
import {parcelsPageRequest} from "../request/admin/parceladminpagerequest";
import {DataTable} from 'react-native-paper';
import {useIsFocused} from "@react-navigation/native";
import ParcelScreen from "./ParcelScreen";
import {createNativeStackNavigator} from "@react-navigation/native-stack";

const AdminScreen = ({navigation}) => {

    const Stack = createNativeStackNavigator();

    function AppTest({navigate, parcel}) {
        return (
            <DataTable.Row>
                <DataTable.Cell>{parcel.id}</DataTable.Cell>
                <DataTable.Cell>{parcel.recipient}</DataTable.Cell>
                <DataTable.Cell>{parcel.parcelStatus[parcel.parcelStatus.length - 1].status}</DataTable.Cell>
                <DataTable.Cell><Button title="Go to" onPress={event => {
                    console.log(parcel.id);
                    navigate.navigate({name: 'ParcelScreen', params: {parcelId: parcel.id}})
                }}/></DataTable.Cell>
            </DataTable.Row>
        )
    }

    let Admin = () => {
        let [error, setError] = useState();
        const [parcels, setParcels] = useState(null);
        const {user, setUser} = useContext(UserContext);

        const isFocused = useIsFocused();
        useEffect(() => {
            parcelsPageRequest(setParcels, setError, user.token);
        }, [isFocused]);


        return (
            <SafeAreaView>
                <ScrollView>
                    <DataTable>
                        <DataTable.Header>
                            <DataTable.Title>Id</DataTable.Title>
                            <DataTable.Title>Recipient</DataTable.Title>
                            <DataTable.Title>Actual status</DataTable.Title>
                            <DataTable.Title>Go to</DataTable.Title>
                        </DataTable.Header>

                        {parcels && parcels.map(parcel => <AppTest key={parcel.id} navigate={navigation} parcel={parcel}/>)}


                    </DataTable>
                </ScrollView>
            </SafeAreaView>

        );
    }
    return (
        <Stack.Navigator>
            <Stack.Screen name="AdminPage" component={Admin}/>
            <Stack.Screen name="ParcelScreen" component={ParcelScreen}/>
        </Stack.Navigator>
    );
};


export default AdminScreen;
