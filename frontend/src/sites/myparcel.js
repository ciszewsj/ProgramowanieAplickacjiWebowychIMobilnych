import {Container, Table} from "react-bootstrap";
import {useState} from "react";

export default function MyParcelSite() {
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

    function Site() {
        const [parcels, setParcels] = useState(null)

        return (
            <Container className="p-3 m-auto">
                <div className="home">
                    <Container className="p-4 m-auto">
                        <Table responsive={"md"} striped={true} border={1} variant={"light"}>
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Created</th>
                                <th>Actual status</th>
                                <th>Open</th>
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

    return Site();
}
