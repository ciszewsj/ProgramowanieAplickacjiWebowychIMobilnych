import {Container, Pagination, Table} from "react-bootstrap";
import {useEffect, useState} from "react";
import {parcelsPageRequest} from "../request/admin/parceladminpagerequest";
import {Navigate, useNavigate} from "react-router-dom";



export const Admin = () => {
    const navigate = useNavigate();

    const [parcels, setParcels] = useState(null)
    const [error, setError] = useState(null)


    function AppTest({parcel}) {
        return (<tr>
            <th scope="row">{parcel.id}</th>
            <td>{parcel.recipient}</td>
            <td>{parcel.parcelStatus.at(-1).status}</td>
            <td>
                <button className="btn btn-primary" onClick={() => {
                    navigate('/parcel/' + parcel.id);

                }}>Go to parcel
                </button>
            </td>
        </tr>)
    }

    useEffect(() => {
        setParcels(null);
        parcelsPageRequest(setParcels, setError)
    }, [])
    if (error) {
        return (<Navigate to="/"/>)
    } else {
        return (
            <Container className="p-3 m-auto">
                <h1>My parcels list</h1>
                <div className="home">
                    <Container className="p-4 m-auto">
                        <Table responsive={"md"} striped={true} border={1} variant={"light"}>
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Recipient</th>
                                <th>Actual status</th>
                                <th>Go to</th>
                            </tr>
                            </thead>
                            <tbody>
                            {parcels && parcels.map(parcel => <AppTest key={parcel.id} parcel={parcel}/>)}
                            </tbody>
                        </Table>
                    </Container>
                </div>
            </Container>
        )
    }
}
