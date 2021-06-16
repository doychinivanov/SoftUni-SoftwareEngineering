function createAndSortTickets(array, sortingCriteria){
    const data = [];

    array.forEach(line => {
        const [destinationName, price, status] = line.split('|');
        const newTicket = createTicket(destinationName, price, status);
        data.push(newTicket);
    });

    return sortTickets(sortingCriteria);

    function createTicket(destination, price, status){
        class Ticket{
            constructor(destination, price, status){
                this.destination = destination;
                this.price = Number(price);
                this.status = status;
            }
        };

        const newTicket = new Ticket(destination, price, status);

        return newTicket;
    }

    function sortTickets(criteria){
        if(criteria == 'price'){
            return data.sort((a,b) => a.price - b.price)
        } else {
            return data.sort((a,b) => a[criteria].localeCompare(b[criteria]));
        }
    }
}

console.log(createAndSortTickets(['Philadelphia|94.20|available'], 'status'));

// console.log(createAndSortTickets(['Philadelphia|94.20|available',
// 'New York City|95.99|available',
// 'New York City|95.99|sold',
// 'Boston|126.20|departed'],
// 'destination'
// ));