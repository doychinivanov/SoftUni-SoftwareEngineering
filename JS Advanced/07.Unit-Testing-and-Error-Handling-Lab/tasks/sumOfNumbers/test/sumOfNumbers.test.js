const {expect} = require('chai');
const sum = require('../sumOfNumbers');

describe('Tests for sum function', ()=>{
    it('sums single number', ()=>{
        expect(sum([1])).to.equal(1);
    });

    //Test overloading
    it('sums two numbers', ()=>{
        expect(sum([2,2])).to.equal(4);
    });

    it('sums multiple numbers', ()=>{
        expect(sum([1,2,3,4])).to.equal(10);
    });

    it('NaN when element in array is NaN', ()=>{
        expect(sum([1, 'string', 2])).to.be.NaN;
    })
});