async function request(url, options) {
    try {
        const response = await fetch(url, options);

        if (response.ok === false) {
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

function getOptions(method = 'get', token, body){
    const options = {
        method,
        headers: {}
    };

    if(token !== null){
        options.headers['X-Authorization'] = token;
    }

    if(body){
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(body)
    }

    return options;
}

export async function get(url, token=null){
    return await request(url, getOptions('get',token))
}

export async function post(url, token=null, data){
    return await request(url, getOptions('post', token, data));
}

export async function put(url, token=null, data){
    return await request(url, getOptions('put', token, data));
}

export async function del(url, token=null){
    return await request(url, getOptions('delete', token));
}