function matrix (num){
    let result = [];
    
    for (let i = 0; i < num; i++) {
        let row = '';
     
        for (let j = 0; j < num; j++) {
            row += num + ' ';
            
        }
        result.push(row)        
    }

    return result.join('\n')
}

console.log(matrix(3));