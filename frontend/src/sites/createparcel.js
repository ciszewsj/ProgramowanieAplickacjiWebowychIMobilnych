import {useState} from "react";
import {useContext} from "react";
import {UserContext} from "../index";
import {CreateParcelRequest} from "../request/parcel/createparcelrequest";
import {Navigate} from "react-router-dom";

export default function CreateParcelSite() {
    const [fields, setFields] = useState({});
    const [errorFields, setErrorFields] = useState({});
    const [error, setError] = useState({errorCode: "", errorMessage: "", createdParcelId: 0});

    const createRequest = () => {
        CreateParcelRequest(fields, setErrorFields, setError);
    }

    function Navigation() {
        return (
            <div className="container p-3 m-auto">
                <form>
                    <div className="form-group">
                        <label htmlFor="name">Name</label>
                        <input type="text" className="form-control" id="name" aria-describedby="nameHelp"
                               placeholder="Name" onChange={e => setFields(() => {
                            fields.name = e.target.value;
                            return fields;
                        })}/>
                        {errorFields.name &&
                            <><span className="error text-danger">{errorFields.name}</span><br/></>}


                        <label htmlFor="email">Email address</label>
                        <input type="email" className="form-control" id="email" aria-describedby="emailHelp"
                               placeholder="Email" onChange={e => setFields(() => {
                            fields.email = e.target.value;
                            return fields;
                        })}/>
                        {errorFields.email &&
                            <><span className="error text-danger">{errorFields.email}</span><br/></>}

                        <label htmlFor="postCode">Post code</label>
                        <input type="text" className="form-control" id="postCode" aria-describedby="postCodeHelp"
                               placeholder="Post code" onChange={e => setFields(() => {
                            fields.postCode = e.target.value;
                            return fields;
                        })}/>
                        {errorFields.postCode &&
                            <><span className="error text-danger">{errorFields.postCode}</span><br/></>}

                        <label htmlFor="city">City</label>
                        <input type="text" className="form-control" id="city" aria-describedby="emailHelp"
                               placeholder="City" onChange={e => setFields(() => {
                            fields.city = e.target.value;
                            return fields;
                        })}/>
                        {errorFields.city &&
                            <><span className="error text-danger">{errorFields.city}</span><br/></>}

                        <label htmlFor="street">Street</label>
                        <input type="text" className="form-control" id="street" aria-describedby="streetHelp"
                               placeholder="Street" onChange={e => setFields(() => {
                            fields.street = e.target.value;
                            return fields;
                        })}/>
                        {errorFields.street &&
                            <><span className="error text-danger">{errorFields.street}</span><br/></>}

                        <label htmlFor="houseNumber">House number</label>
                        <input type="text" className="form-control" id="houseNumber"
                               aria-describedby="houseNumberHelp"
                               placeholder="House number" onChange={e => setFields(() => {
                            fields.houseNumber = e.target.value;
                            return fields;
                        })}/>
                        {errorFields.houseNumber &&
                            <><span className="error text-danger">{errorFields.houseNumber}</span><br/></>}

                    </div>
                    <button type="button" className="btn btn-primary" onClick={createRequest}>Submit</button>
                </form>
            </div>
        )
    }

    if (error.errorCode !== 200 && error.errorCode !== 201) {
        return Navigation();
    } else {
        let path = "/parcel/" + error.createdParcelId;
        return (<Navigate to={path}/>);
    }
}
