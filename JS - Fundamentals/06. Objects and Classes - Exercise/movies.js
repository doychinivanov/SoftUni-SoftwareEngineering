function solve(arr) {
    const movies = [];
    const result = [];

    arr.forEach(line => {
        const currentMovie = {};
        if (line.includes('addMovie')) {
            const movieName = line.substring(9);
            currentMovie.name = movieName;
            movies.push(currentMovie);
        }

        if (line.includes('directedBy')) {
            let [movieName, directorName] = line.split(' directedBy ');
            const myMovie = movies.find(x => x.name === movieName);

            if (myMovie) {
                myMovie.director = directorName;
            }
        }

        if (line.includes('onDate')) {
            let [movieName, date] = line.split(' onDate ');
            const myMovie = movies.find(x => x.name === movieName);

            if (myMovie) {
                myMovie.date = date;
            }
        }
    });

    movies
        .filter(movie => movie.name && movie.director && movie.date)
        .forEach(x => {
            result.push(JSON.stringify(x))
        });

    return result.join('\n')
}

console.log(solve(
    [
        'addMovie Fast and Furious',
        'addMovie Godfather',
        'Inception directedBy Christopher Nolan',
        'Godfather directedBy Francis Ford Coppola',
        'Godfather onDate 29.07.2018',
        'Fast and Furious onDate 30.07.2018',
        'Batman onDate 01.08.2018',
        'addMovie Batman',
        'Fast and Furious directedBy Rob Cohen'
    ]
));