import {getSession} from "../../controllers/sessioncontroller";

export let GetMyParcelRequest = (setParcels, setPagination, setError) => {
    fetch('http://localhost:8080/api/parcel',
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
                    console.log(json);
                    setParcels(json.content);
                    setPagination(() => {
                        let pag = {};
                        pag.number = json.number;
                        pag.totalPages = json.totalPages;
                        return pag;
                    })
                });
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
        });
}
