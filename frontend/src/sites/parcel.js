import {Container, Table} from "react-bootstrap";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {parcelRequest} from "../request/parcel/parcelrequest";
import React from "react";
import Error from "./Error";

export default function ParcelSite() {

    let [info, setInfo] = useState({});
    let [error, setError] = useState({code: 0, message: "Not Load"});
    let {id} = useParams();

    useEffect(() => {
        console.log(id)
        parcelRequest(id, setInfo, setError);
    }, []);

    function AppTest({stat}) {
        console.log(stat)
        return (<tr>
            <td>{stat.status}</td>
            <td>{stat.date}</td>
        </tr>)
    }


    function Site() {
        return (
            <Container className="p-3 m-auto">
                <h1>Parcel</h1>
                <Container className="p-3 m-auto">
                    <div className="row">
                        <div className="col">
                            <h5>Parcel id:</h5>
                        </div>
                        <div className="col">
                            {info.id && <p>{info.id}</p>}
                        </div>
                    </div>
                    <div className="row">

                        <div className="col">
                            <h5>Recipient name:</h5>
                        </div>
                        <div className="col">
                            {info.recipient && info.recipient.name && <p>{info.recipient.name}</p>}
                        </div>
                    </div>
                    <div className="row">

                        <div className="col">
                            <h5>Recipient email:</h5>
                        </div>
                        <div className="col">
                            {info.recipient && info.recipient.email &&
                                <p>{info.recipient.email}</p>}
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <h5>Send:</h5>
                        </div>
                        <div className="col">
                            {info.sendDate ? <p>{info.recipient.email}</p> : <p>PARCEL NOT SENT</p>}
                        </div>
                    </div>
                </Container>
                <Table responsive={"md"} striped={true} border={1} variant={"light"}>
                    <thead>
                    <tr>
                        <th>Status</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {info.parcelStatus && info.parcelStatus.map(stat => <AppTest key={stat.id} stat={stat}/>)}
                    </tbody>
                </Table>
            </Container>
        )
    }

    if (error.code === 200) {
        return Site();
    } else if (error.code === 0) {
        return <p>loading...</p>
    } else {
        return <Error/>
    }
}
