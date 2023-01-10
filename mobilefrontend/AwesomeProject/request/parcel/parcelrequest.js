import {getSession} from "../../controllers/sessioncontroller";

export let parcelRequest = (id, setParcel, setError) => {
    fetch('http://10.12.6.35:8080/api/parcel/' + id,
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
                    setParcel(json);
                    let err = {code: 200, message: json.message}
                    setError(err)
                });
            } else if (response.status === 409) {
                response.json().then(json => {
                    let err = {code: 409, message: json.message}
                    setError(err)
                })
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
            setError(e.toString());
            setError(() => {
                return {
                    status: 400,
                    message: e.toString()
                };
            });
        })
}
