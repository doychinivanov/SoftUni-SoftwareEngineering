function solve(arr){
    const songs = arr.shift();
    const seekedPlaylist = arr.pop();
    const result = [];

    class Song{
        constructor (playlist, name, time){
            this.playlist = playlist;
            this.name = name;
            this.time = time;
        }
    }


    arr.forEach(line => {
        let [currentPlaylist, currentSong, currentTime] = line.split('_');
        if(seekedPlaylist === 'all'){
            result.push(createSong());
        } 

        if(seekedPlaylist === currentPlaylist){
            result.push(createSong());
        }


        function createSong (){
            let song = new Song(currentPlaylist, currentSong, currentTime);
            return song.name;
        }
    });

    return result.join('\n')
}

console.log(solve(
    [3,
        'favourite_DownTown_3:14',
        'favourite_Kiss_4:16',
        'favourite_Smooth Criminal_4:01',
        'favourite']        
));