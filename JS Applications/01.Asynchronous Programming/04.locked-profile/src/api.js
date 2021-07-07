export async function getAllUsers(){
    try{
        const response = await fetch('http://localhost:3030/jsonstore/advanced/profiles');
        const data = await response.json();

        return data;
    } catch(err) {
        alert('Something went wrong. Try again later.')
        return 'Error';
    }
}