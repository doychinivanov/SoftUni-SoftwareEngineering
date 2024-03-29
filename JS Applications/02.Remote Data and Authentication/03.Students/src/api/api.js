async function request(url, options) {
    try {
        const response = await fetch(url, options);

        if (response.ok == false) {
            const error = await response.json();
            throw new Error(error.message);
        }

        try {
            const data = await response.json();
            return data;
        } catch (err) {
            return response;
        }
    } catch (err) {
        throw err;
    }
}

function getOptions(method = 'get', body){
    const options = {
        method,
        headers: {}
    };

    const token = sessionStorage.getItem('authToken')

    if(token !== null){
        options.headers['X-Parse-Session-Token'] = token;
    }

    if(body){
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(body);
    }

    return options;
}

export async function get(url){
    return await request(url, getOptions())
}

export async function post(url, data){
    return await request(url, getOptions('post', data));
}