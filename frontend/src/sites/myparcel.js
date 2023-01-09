import {Container, Table} from "react-bootstrap";
import {useState, useEffect} from "react";
import {parcelsPageRequest} from "../request/parcel/parcelpagerequest";
import {useNavigate} from 'react-router-dom';

export default function MyParcelSite() {
    const navigate = useNavigate();

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

    let [error, setError] = useState();

    function Site() {
        const [parcels, setParcels] = useState(null);

        useEffect(() => {
            parcelsPageRequest(setParcels, setError);
        }, []);


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

    if (!error) {
        return Site();
    } else {
        navigate('/');
    }
}
