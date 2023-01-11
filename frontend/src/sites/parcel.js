import {Button, Container, Table} from "react-bootstrap";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {parcelRequest} from "../request/parcel/parcelrequest";
import React from "react";
import Error from "./Error";
import {getSession} from "../controllers/sessioncontroller";
import {changeParcelStatus} from "../request/admin/parcelsubmitadminrequest";
import {useNavigate} from "react-router-dom";

export default function ParcelSite() {
    const navigate = useNavigate();

    let [info, setInfo] = useState({});
    let [error, setError] = useState({code: 0, message: "Not Load"});
    let [errorSubmit, setErrorSubmit] = useState();
    let {id} = useParams();
    let role = getSession().role;

    console.log(role)

    useEffect(() => {
        parcelRequest(id, setInfo, setError);
    }, [errorSubmit]);

    function AppTest({stat}) {
        return (<tr>
            <td>{stat.status}</td>
            <td>{stat.date && stat.date.split("T")[0]}</td>
            <td>{stat.date && stat.date.split("T")[1].split(".")[0]}</td>
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
                            <h5>Sender name:</h5>
                        </div>
                        <div className="col">
                            {info.sender && <p>{info.sender}</p>}
                        </div>
                    </div>
                    <div className="row">

                        <div className="col">
                            <h5>Recipient name:</h5>
                        </div>
                        <div className="col">
                            {info.recipient && <p>{info.recipient}</p>}
                        </div>
                    </div>
                    {info.address &&
                        <>
                            <div className="row">
                                <div className="col">
                                    <h5>Address:</h5>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <h5>Post code:</h5>
                                </div>
                                <div className="col">
                                    {info.address.postCode && <p>{info.address.postCode}</p>}
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <h5>City:</h5>
                                </div>
                                <div className="col">
                                    {info.address.city && <p>{info.address.city}</p>}
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <h5>Street:</h5>
                                </div>
                                <div className="col">
                                    {info.address.street && <p>{info.address.street}</p>}
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <h5>House number:</h5>
                                </div>
                                <div className="col">
                                    {info.address.houseNumber && <p>{info.address.houseNumber}</p>}
                                </div>
                            </div>
                        </>

                    }
                    <div className="row">
                        <div className="col">
                            <h5>Send:</h5>
                        </div>
                        <div className="col">
                            {info.parcelStatus.at(-1).status === "NOT_SENT" ?
                                <p>PARCEL NOT SENT</p> : <p>PARCEL SENT</p>}
                        </div>
                    </div>
                    {role && role === "ROLE_admin" && <>
                        {
                            info.parcelStatus && info.parcelStatus.at(-1).status === "NOT_SENT" &&
                            <Button
                                onClick={() => {
                                    changeParcelStatus(info.id, "SENT", setErrorSubmit);

                                }}
                            >Send Package</Button>
                        }
                        {
                            info.parcelStatus && info.parcelStatus.at(-1).status === "SENT" &&
                            <Button
                                onClick={() => {
                                    changeParcelStatus(info.id, "DELIVERED", setErrorSubmit);
                                }}
                            >Set Delivered</Button>
                        }
                    </>
                    }

                </Container>
                <Table responsive={"md"} striped={true} border={1} variant={"light"}>
                    <thead>
                    <tr>
                        <th>Status</th>
                        <th>Date</th>
                        <th>Time</th>
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
