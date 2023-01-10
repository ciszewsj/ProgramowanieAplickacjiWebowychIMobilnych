import {Button, Text} from "react-native";
import {SafeAreaView, StyleSheet, TextInput} from "react-native";
import React from "react";

const MainScreen = ({navigation}) => {
    const [parcelId, setParcelId] = React.useState(0);
    return (
        <SafeAreaView>
            <Text>Parcel id</Text>

            <TextInput
                keyboardType="numeric"
                onChangeText={setParcelId}
                value={parcelId}
            />
            <Button
                title="Find parcel"
                onPress={() =>
                    navigation.navigate('Parcel', {parcelId: parcelId})
                }
            />
        </SafeAreaView>

    );
};




export default MainScreen;
