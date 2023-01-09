import {useNavigate} from 'react-router-dom';
import {useState} from "react";


export default function MainSite() {
    const navigate = useNavigate();
    let [id, setId] = useState();

    function Site() {
        return (
            <div className="container p-3 m-auto">

                <form className="form-inline" action="/action_page.php">
                    <div className="form-group">
                        <label htmlFor="parcel_id">Parcel number:</label>
                        <input type="number" className="form-control" id="parcel_id"
                               onChange={e => setId(e.target.value)}/>
                    </div>
                    <button type="submit" className="btn btn-light btn-lg p-3 m-sm-1"
                            onClick={() => {
                                navigate('/parcel/' + id);
                            }}
                    >Search
                    </button>
                </form>

            </div>
        )
    }

    return Site();
}
