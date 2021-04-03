function solve(arr){
    const actions = {
        'New follower' : (followers, [username])=>{
            if(!followers.hasOwnProperty(username)){
                followers[username] = 0;
            }

            return followers;
        },
        Like : (followers, [username, likes]) =>{
            likes = Number(likes);
            if(followers.hasOwnProperty(username)){
                followers[username] += likes;
            } else {
                followers[username] = likes;
            }

            return followers;
        },
        Comment : (followers, [username]) =>{
            if(followers.hasOwnProperty(username)){
                followers[username] += 1;
            } else {
                followers[username] = 1;
            }

            return followers;
        },
        Blocked : (followers, [username]) =>{
            if(followers.hasOwnProperty(username)){
                delete followers[username];
            } else {
                console.log(`${username} doesn\'t exist.`);
            }

            return followers;
        }
    }


    let followers = {};
    while((line = arr.shift()) !== 'Log out'){
        const [command, ...params] = line.split(': ');
        const action = actions[command];
        followers = action(followers, params);
    }

    const sortedFollowers = Object.entries(followers).sort((a,b) => b[1] - a[1] || a[0].localeCompare(b[0]));
    console.log(`${sortedFollowers.length} followers`);
    sortedFollowers.forEach(f => console.log(`${f[0]}: ${f[1]}`))
}

solve(["Like: A: 3",
"Comment: A",
"New follower: B",
"Blocked: A",
"Comment: B",
"Like: C: 5",
"Like: D: 5",
"Log out"])

