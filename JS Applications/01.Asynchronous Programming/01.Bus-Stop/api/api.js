async function request(url, options) {
    const response = await fetch(url, options);

    if (response.ok == false) {
        const error = await response.json();
        throw new Error(error.message);
    }

    const data = await response.json();
    return data;
}

function getOptions(method = 'get', body) {
    const options = {
        method,
        headers: {}
    };

    if (body) {
        options.headers['Content-Type'] = 'application/json';
        options.body = JSON.stringify(body)
    }

    return options;
}

export async function get(url) {
    return await request(url, getOptions())
}