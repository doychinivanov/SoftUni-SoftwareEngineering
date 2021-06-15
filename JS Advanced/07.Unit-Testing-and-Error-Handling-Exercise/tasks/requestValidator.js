function validateHTTPRequest(req){
    const validMethods = ['POST', 'GET', 'DELETE', 'CONNECT'];
    const validVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/1.2', 'HTTP/2.0'];
    const validMsg = /^[^\<\>\\\&\'\"]+$/gm;
    const validURL = /^[A-Za-z\.0-9]+$/gm;
    const errorMsg = 'Invalid request header: Invalid ';


    if(req.hasOwnProperty('method') == false || validMethods.includes(req.method) == false){
        throw new Error(errorMsg + 'Method');
    } else if(req.hasOwnProperty('uri') == false || req.uri != '*' && validURL.test(req.uri) == false){
        throw new Error(errorMsg + 'URI');
    } else if(req.hasOwnProperty('version') == false ||validVersions.includes(req.version) == false){
        throw new Error(errorMsg + 'Version');
    } else if(req.hasOwnProperty('message') == false || req.message != '' && validMsg.test(req.message) == false){
        throw new Error(errorMsg + 'Message');
    }

    return req;
}

// console.log(validateHTTPRequest({
//     method: 'GET',
//     uri: '*',
//     version: 'HTTP/1.1',
//     message: ''
//   }
// ));

// console.log(validateHTTPRequest(
//     {
//     method: 'OPTIONS',
//     uri: 'git.master',
//     version: 'HTTP/1.1',
//     message: '-recursive'
//     }
// ));

console.log(validateHTTPRequest({
    method: 'POST',
    uri: 'home.bash',
    version: 'HTTP/2.0'
  }
  ));