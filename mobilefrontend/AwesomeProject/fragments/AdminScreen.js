import {Button, Text} from "react-native";
import {SafeAreaView, StyleSheet, TextInput} from "react-native";
import React, {useContext, useEffect, useState} from "react";
import {UserContext} from "../App";
import {parcelsPageRequest} from "../request/admin/parceladminpagerequest";
import {DataTable} from 'react-native-paper';
import {useIsFocused} from "@react-navigation/native";

const AdminScreen = ({navigation}) => {
    let [error, setError] = useState();
    const [parcels, setParcels] = useState(null);
    const {user, setUser} = useContext(UserContext);

    const isFocused = useIsFocused();


    function AppTest({parcel}) {
        return (
            <DataTable.Row>
                <DataTable.Cell>{parcel.id}</DataTable.Cell>
                <DataTable.Cell>{parcel.recipient}</DataTable.Cell>
                <DataTable.Cell>{parcel.parcelStatus[parcel.parcelStatus.length - 1].status}</DataTable.Cell>
                <DataTable.Cell><Button title="Go to" onPress={console.log("")}/></DataTable.Cell>
            </DataTable.Row>
        )
    }

    useEffect(() => {
        parcelsPageRequest(setParcels, setError, user.token);
    }, [isFocused]);

    console.log(parcels)

    return (
        <SafeAreaView>
            <DataTable>
                <DataTable.Header>
                    <DataTable.Title>Id</DataTable.Title>
                    <DataTable.Title>Recipient</DataTable.Title>
                    <DataTable.Title>Actual status</DataTable.Title>
                    <DataTable.Title>Go to</DataTable.Title>
                </DataTable.Header>

                {parcels && parcels.map(parcel => <AppTest key={parcel.id} parcel={parcel}/>)}


            </DataTable>
        </SafeAreaView>

    );
};


export default AdminScreen;
