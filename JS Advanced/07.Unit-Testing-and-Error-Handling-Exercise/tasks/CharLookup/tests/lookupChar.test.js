const {expect} = require('chai');
const lookupChar = require('../lookupChar');

describe('Testing lookupChar functions', ()=>{
    describe('Testing the happy path', ()=>{
        it('happy path', ()=>{
            expect(lookupChar('abc', 0)).to.equal('a');
        });

        it('happy path', ()=>{
            expect(lookupChar('abc', 1)).to.equal('b');
        });

        it('happy path', ()=>{
            expect(lookupChar('abc', 2)).to.equal('c');
        });
    });

    describe('Testing incorrect type input', ()=>{
        it('testing wrong first input', ()=>{
            expect(lookupChar(['a'], 0)).to.be.undefined;
        });

        it('testing wrong first input', ()=>{
            expect(lookupChar(11, 0)).to.be.undefined;
        });

        it('testing wrong first input', ()=>{
            expect(lookupChar({x:1}, 0)).to.be.undefined;
        });

        it('testing wrong second input', ()=>{
            expect(lookupChar('abc', 'a')).to.be.undefined;
        });

        it('testing wrong second input', ()=>{
            expect(lookupChar('abc', 1.1)).to.be.undefined;
        });

        it('testing wrong second input', ()=>{
            expect(lookupChar('abc', 0.5)).to.be.undefined;
        });

        it('testing wrong second input', ()=>{
            expect(lookupChar('abc', [1])).to.be.undefined;
        });

        it('testing wrong second input', ()=>{
            expect(lookupChar('abc', {x:1})).to.be.undefined;
        });

        it('testing two wrong inputs', ()=>{
            expect(lookupChar(1, 'a')).to.be.undefined;
        });

        it('testing two wrong inputs', ()=>{
            expect(lookupChar(['a'], 1.5)).to.be.undefined;
        });
    });

    describe('Test overloading', ()=>{
        it('Testing index out of range', ()=>{
            expect(lookupChar('abc', -1)).to.equal('Incorrect index')
        });

        it('Testing index out of range', ()=>{
            expect(lookupChar('abc', 4)).to.equal('Incorrect index')
        });

        it('Testing index out of range', ()=>{
            expect(lookupChar('', 0)).to.equal('Incorrect index')
        });
    });

});