const {expect} = require('chai');
const isOddOrEven = require('../evenOrOdd');

describe('Testing isOddOrEven function', ()=>{
    describe('Testing happy path', ()=>{
        it('testing even length strings', ()=>{
            expect(isOddOrEven('aa')).to.equal('even');
        });

        it('testing even length strings', ()=>{
            expect(isOddOrEven('aaaa')).to.equal('even');
        });

        it('testing even length strings', ()=>{
            expect(isOddOrEven('aaaaaa')).to.equal('even');
        });

        it('testing odd length strings', ()=>{
            expect(isOddOrEven('a')).to.equal('odd');
        });

        it('testing odd length strings', ()=>{
            expect(isOddOrEven('aaa')).to.equal('odd');
        });

        it('testing odd length strings', ()=>{
            expect(isOddOrEven('aaaaa')).to.equal('odd');
        });
    });

    describe('Testing invalid input arguments', ()=>{
        it('testing invalid input', ()=>{
            expect(isOddOrEven(1)).to.be.undefined;
        });

        it('testing invalid input', ()=>{
            expect(isOddOrEven(11)).to.be.undefined;
        });

        it('testing invalid input', ()=>{
            expect(isOddOrEven([1])).to.be.undefined;
        });

        it('testing invalid input', ()=>{
            expect(isOddOrEven(NaN)).to.be.undefined;
        });

        it('testing invalid input', ()=>{
            expect(isOddOrEven({x:1})).to.be.undefined;
        });
    });

    describe('Overloading', ()=>{
        it('testing edge case with empty string', ()=>{
            expect(isOddOrEven('')).to.equal('even');
        });
    });
});