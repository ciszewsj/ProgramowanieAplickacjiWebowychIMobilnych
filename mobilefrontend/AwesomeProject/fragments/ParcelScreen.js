import {Button, ScrollView, Text} from "react-native";
import {SafeAreaView, StyleSheet, TextInput} from "react-native";
import React, {useContext, useEffect, useState} from "react";
import {UserContext} from "../App";
import {parcelRequest} from "../request/parcel/parcelrequest";
import {DataTable} from "react-native-paper";
import {changeParcelStatus} from "../request/admin/parcelsubmitadminrequest";

const ParcelScreen = ({navigation, route}) => {
    let [info, setInfo] = useState({});
    let [error, setError] = useState({code: 0, message: "Not Load"});
    let [errorSubmit, setErrorSubmit] = useState();
    const {user} = useContext(UserContext);
    let role = user.role;

    useEffect(() => {
        parcelRequest(route.params?.parcelId, setInfo, setError, user.token ? user.token : "");
        console.log(error);
    }, [errorSubmit, route.params?.parcelId]);

    function AppTest({stat}) {
        return (
            <DataTable.Row>

                <DataTable.Cell>{stat.status}</DataTable.Cell>
                <DataTable.Cell>{stat.date && stat.date.split("T")[0]}</DataTable.Cell>
                <DataTable.Cell>{stat.date && stat.date.split("T")[1].split(".")[0]}</DataTable.Cell>
            </DataTable.Row>)
    }

    return (
        <SafeAreaView>
            {error.code === 200 ?
                <ScrollView>
                    <Text>Parcel id</Text>
                    {info.id && <Text>{info.id}</Text>}
                    <Text>Sender:</Text>
                    {info.sender && <Text>{info.sender}</Text>}
                    <Text>Recipient:</Text>
                    {info.recipient && <Text>{info.recipient}</Text>}
                    {
                        info.address &&
                        <>
                            <Text>Address</Text>
                            <Text>Post code:</Text>
                            {info.address.postCode && <Text>{info.address.postCode}</Text>}
                            <Text>City:</Text>
                            {info.address.postCode && <Text>{info.address.city}</Text>}
                            <Text>Street:</Text>
                            {info.address.street && <Text>{info.address.street}</Text>}
                            <Text>House number:</Text>
                            {info.address.houseNumber && <Text>{info.address.houseNumber}</Text>}
                        </>

                    }
                    {role && role === "ROLE_admin" && <>
                        {
                            info.parcelStatus && info.parcelStatus[info.parcelStatus.length - 1].status === "NOT_SENT" &&
                            <Button
                                title="Send package"
                                onPress={() => {
                                    changeParcelStatus(route.params?.parcelId, "SENT", setErrorSubmit, user.token)
                                }}/>
                        }
                        {
                            info.parcelStatus && info.parcelStatus[info.parcelStatus.length - 1].status === "SENT" &&
                            <Button
                                title="Set delivered"
                                onPress={() => {
                                    changeParcelStatus(route.params?.parcelId, "DELIVERED", setErrorSubmit, user.token)
                                }}/>
                        }</>
                    }
                    <DataTable>
                        <DataTable.Header>
                            <DataTable.Title>Status</DataTable.Title>
                            <DataTable.Title>Date</DataTable.Title>
                            <DataTable.Title>Time</DataTable.Title>
                        </DataTable.Header>

                        {info.parcelStatus && info.parcelStatus.map(stat => <AppTest key={stat.id} stat={stat}/>)}


                    </DataTable>
                </ScrollView> :
                <Text>Parcel not found</Text>}
        </SafeAreaView>

    );
};


export default ParcelScreen;
