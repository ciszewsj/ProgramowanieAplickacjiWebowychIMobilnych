import {getSession} from "../../controllers/sessioncontroller";

export let parcelsPageRequest = (setParcels, setError) => {

    fetch('http://localhost:8080/api/admin/parcel',
        {
            "mode": "cors",
            "method": "GET",
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
                Authorization: `Bearer ${getSession().token}`
            }
        }
    )
        .then(response => {

            if (response.status === 200) {
                response.json().then(json => {
                    setParcels(json)
                });
                setError(...null);
            } else {
                setError(() => {
                    return {
                        status: 400,
                        message: response
                    };
                });
            }
        })
        .catch(e => {
            console.log("ERROR")
            setError(e.toString());
        });
}
