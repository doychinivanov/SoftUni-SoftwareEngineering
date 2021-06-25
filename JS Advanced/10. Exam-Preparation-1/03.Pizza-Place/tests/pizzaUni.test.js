const {expect} = require('chai');
const pizzUni = require('../pizzaUni');

describe('Testing functions', ()=>{
    describe('Testing makeAnOrder functionallity', ()=>{
        describe('Testing the happy path', ()=>{

            it('Testing without drink', ()=>{
                expect(pizzUni.makeAnOrder({orderedPizza:'a'})).to.equal('You just ordered a')
            });
        
            it('Testing with full order', ()=>{
                expect(pizzUni.makeAnOrder({orderedPizza:'a', orderedDrink: 'b'})).to.equal('You just ordered a and b.')
            });
        });

        describe('Testing an error', ()=>{
            it('Missing field', ()=>{
                expect(()=>pizzUni.makeAnOrder({})).to.throw(Error, 'You must order at least 1 Pizza to finish the order.');
            });

            it('Missing field', ()=>{
                expect(()=>pizzUni.makeAnOrder({orderedDrink: 'b'})).to.throw(Error, 'You must order at least 1 Pizza to finish the order.');
            });
        })
    });

    describe('Testing getRemainingWork functionallity',()=>{
        describe('Testing the happy path', ()=>{
            it('Test with empty array', ()=>{
                expect(pizzUni.getRemainingWork([])).to.equal('All orders are complete!');
            });

            it('Testing with some pizzas in prep', ()=>{
                expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'preparing'}, {pizzaName: 'b', status: 'preparing'}])).to.equal('The following pizzas are still preparing: a, b.');
            });

            it('Testing with some pizzas in prep and some ready', ()=>{
                expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'preparing'}, {pizzaName: 'b', status: 'preparing'}, {pizzaName: 'c', status: 'ready'}])).to.equal('The following pizzas are still preparing: a, b.');
            });

            it('Testing with all pizza ready', ()=>{
                expect(pizzUni.getRemainingWork([{pizzaName: 'a', status: 'ready'}, {pizzaName: 'b', status: 'ready'}, {pizzaName: 'c', status: 'ready'}])).to.equal('All orders are complete!');
            });
        });
    });

    describe('Testing the orderType functionallity',()=>{
        describe('Testing Delivery', ()=>{
            it('delivery resting', ()=>{
                expect(pizzUni.orderType(1, 'Delivery')).to.equal(1);
            });

            it('delivery resting', ()=>{
                expect(pizzUni.orderType(2, 'Delivery')).to.equal(2);
            });
        });

        describe('Testing Carry Out', ()=>{
            it('carry out', ()=>{
                expect(pizzUni.orderType(1, 'Carry Out')).to.equal(0.9);
            });

            it('carry out', ()=>{
                expect(pizzUni.orderType(10, 'Carry Out')).to.equal(9);
            });
        })
    });
});