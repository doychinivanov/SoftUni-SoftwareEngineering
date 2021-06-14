const {expect} = require('chai');
const isSymmetric = require('../isSymmetric');

describe('testing the isSymmetric functions', ()=>{

    describe('testing happy path', ()=>{
        it('testing a symmetrical input with numbers', ()=>{
            expect(isSymmetric([1, 1, 1])).to.be.true;
        });
    
        it('testing a symmetrical input with strings', ()=>{
            expect(isSymmetric(['a', 'a'])).to.be.true;
        });
    
        it('testing a symmetrical input with mix types', ()=>{
            expect(isSymmetric(['a', 1, 'a'])).to.be.true;
        });
    });

    describe('testing a wrong input', ()=>{
        it('testing wrong input with a string', ()=>{
            expect(isSymmetric('a')).to.be.false;
        });
    
        it('testing wrong input with a number', ()=>{
            expect(isSymmetric(1, 1)).to.be.false;
        });
    
        it('testing wrong input with an object', ()=>{
            expect(isSymmetric({x:1, y:1})).to.be.false;
        });
    });

    describe('testing non symmetric valid inputs', ()=>{
        it('testing asymmetric array with mixed values', ()=>{
            expect(isSymmetric([1, '1'])).to.be.false;
        });

        it('testing asymmetric array with even length', ()=>{
            expect(isSymmetric([1, '1', 1, '1'])).to.be.false;
        });
    })


});