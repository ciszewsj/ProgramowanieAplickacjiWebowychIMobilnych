import {Container, Pagination, Table} from "react-bootstrap";
import {useEffect, useState} from "react";
import {parcelsPageRequest} from "../request/admin/parceladminpagerequest";
import {Navigate} from "react-router-dom";

function AppTest({parcel}) {
    return (<tr>
        <th scope="row">{parcel.id}</th>
        <td>{parcel.name}</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>
            <button className="btn btn-primary">Submit</button>
        </td>
    </tr>)
}

export const Admin = () => {

    const [parcels, setParcels] = useState(null)
    const [error, setError] = useState(null)

    useEffect(() => {
        setParcels(null);
        parcelsPageRequest(setParcels, setError)
    }, [])
    if (error) {
        return (<Navigate to="/"/>)
    } else {
        return (
            <div className="home">
                <Container className="p-4 m-auto">
                    <Table responsive={"md"} striped={true} border={1} variant={"light"}>
                        <thead>
                        <tr>
                            <th>parcelId</th>
                            <th>customerId</th>
                            <th>create</th>
                            <th>actual status</th>
                            <th>edit status</th>
                        </tr>
                        </thead>
                        <tbody>
                        {parcels && parcels.map(parcel => <AppTest key={parcel.id} parcel={parcel}/>)}
                        </tbody>
                    </Table>
                </Container>
                )
            </div>
        );
    }
}
