class Restaurant{
    constructor(budgetMoney){
        this.budgetMoney = Number(budgetMoney);
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    };

    loadProducts(array){
        const result = [];

        array.forEach(line => {
           let [productName, quantity, totalPrice] = line.split(' ');
            quantity = Number(quantity);
            totalPrice = Number(totalPrice);

            if(this.budgetMoney >= totalPrice){

                if(!this.stockProducts.hasOwnProperty(productName)){
                    this.stockProducts[productName] = 0;
                }

                this.stockProducts[productName] += quantity;
                this.budgetMoney -= totalPrice;
                this.history.push(`Successfully loaded ${quantity} ${productName}`);
                result.push(`Successfully loaded ${quantity} ${productName}`)
            } else {
                this.history.push(`There was not enough money to load ${quantity} ${productName}`);
                result.push(`There was not enough money to load ${quantity} ${productName}`);
            }
        });

        return result.join('\n');
    };

    addToMenu(proposedMeal, neededProducts, price){
        price = Number(price);

        if(!this.menu.hasOwnProperty(proposedMeal)){
            this.menu[proposedMeal] = {
                products: neededProducts,
                price: price
            };

            if(Object.keys(this.menu).length == 1){
                return `Great idea! Now with the ${proposedMeal} we have 1 meal in the menu, other ideas?`;
            } else {
                return `Great idea! Now with the ${proposedMeal} we have ${Object.keys(this.menu).length} meals in the menu, other ideas?`;
            }

        } else {
            return `The ${proposedMeal} is already in the our menu, try something different.`;
        }
    };

    showTheMenu(){
        const result = [];;

        if(Object.keys(this.menu).length > 0){
            
            for (const key in this.menu) {
                result.push(`${key} - \$ ${this.menu[key].price}`);
            }

            return result.join('\n');
        } else {
            return 'Our menu is not ready yet, please come later...';
        }

    };

    makeTheOrder(requestedMeal){
        const currentMeal = this.menu[requestedMeal];

        if(currentMeal){
            let haveAllProducts = true;
            
            for (let i = 0; i < this.menu[requestedMeal].products.length; i++) {
                let [neededProduct, neededQuantiy] = this.menu[requestedMeal].products[i].split(' ');
                neededQuantiy = Number(neededQuantiy);
                
                if((this.stockProducts.hasOwnProperty(neededProduct) && this.stockProducts[neededProduct] >= neededQuantiy) == false){
                    haveAllProducts = false;
                    break;
                }
            }

            if(haveAllProducts){
                currentMeal.products.forEach(product => {
                    let [productName, productQuantity] = product.split(' ');
                    this.stockProducts[productName] -= Number(productQuantity);
                });

                this.budgetMoney += currentMeal.price;
                return `Your order (${requestedMeal}) will be completed in the next 30 minutes and will cost you ${currentMeal.price}.`;
            } else {
                return `For the time being, we cannot complete your order (${requestedMeal}), we are very sorry...`;
            }

        } else {
            return `There is not ${requestedMeal} yet in our menu, do you want to order something else?`;
        }
    }
}



let kitchen = new Restaurant(10);
console.log(kitchen.loadProducts(['Banana 10 5', 'Banana 20 10', 'Strawberries 50 30', 'Yogurt 10 10', 'Yogurt 500 1500', 'Honey 5 50']));
console.log(kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99));
console.log(kitchen.addToMenu('Pizza', ['Flour 0.5', 'Oil 0.2', 'Yeast 0.5', 'Salt 0.1', 'Sugar 0.1', 'Tomato sauce 0.5', 'Pepperoni 1', 'Cheese 1.5'], 15.55));
console.log(kitchen.showTheMenu());
console.log(kitchen.makeTheOrder('frozenYogurt'));