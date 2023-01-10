import {addSession} from "../sessioncontroller";

export let LoginRequest = (setLoginUser, setError, login, password) => {
    fetch('http://10.12.6.35:8080/api/customer/login',
        {
            "mode": "cors",
            "method": "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            "body": JSON.stringify(
                {
                    username: login,
                    password: password
                }
            )

        }
    )
        .then(response => {
            if (response.status === 200) {
                response.json().then(json => {
                    setLoginUser(addSession(json.jwttoken))
                });
            } else {
                try {
                    response.json().then(json => {
                        setError(JSON.stringify(json));
                    })
                } catch {
                    setError(response.status);
                }
            }
        })
        .catch(e => {
            setError(e.toString());
        });
}
