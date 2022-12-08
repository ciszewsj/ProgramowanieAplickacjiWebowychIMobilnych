import {Container, Table} from "react-bootstrap";

export default function ParcelSite() {
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
                            <p>{123}</p>
                        </div>
                    </div>
                    <div className="row">

                        <div className="col">
                            <h5>Recipient name:</h5>
                        </div>
                        <div className="col">
                            <p>{123}</p>
                        </div>
                    </div>
                    <div className="row">

                        <div className="col">
                            <h5>Recipient email:</h5>
                        </div>
                        <div className="col">
                            <p>{123}</p>
                        </div>
                    </div>
                    <div className="row">

                        <div className="col">
                            <h5>Actual status:</h5>
                        </div>
                        <div className="col">
                            <p>{123}</p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <h5>Send:</h5>
                        </div>
                        <div className="col">
                            <p>{123}</p>
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
                    </tbody>
                </Table>
            </Container>
        )
    }

    return Site();
}
