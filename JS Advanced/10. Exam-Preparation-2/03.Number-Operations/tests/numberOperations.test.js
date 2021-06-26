const {expect} = require('chai');
const numberOperations = require('../numberOperations');

describe('Testing a set of functions', ()=>{
    describe('Testing the pow functionallity', ()=>{
        it('test pow of n', ()=>{
            expect(numberOperations.powNumber(1)).to.equal(1);
        });

        it('test pow of n', ()=>{
            expect(numberOperations.powNumber(2)).to.equal(4);
        });

        it('test pow of n', ()=>{
            expect(numberOperations.powNumber(5)).to.equal(25);
        });

        it('test pow of n', ()=>{
            expect(numberOperations.powNumber(1.1)).to.be.closeTo(1.21, 0.01);
        });

        it('test pow of n', ()=>{
            expect(numberOperations.powNumber(1.5)).to.be.closeTo(2.25, 0.01);
        });
    });

    describe('Testing the numberChecker func', ()=>{
        describe('Testing NaN', ()=>{
            it('String input', ()=>{
                expect(()=>numberOperations.numberChecker('a')).to.throw(Error, 'The input is not a number!');
            });

            it('Array input', ()=>{
                expect(()=>numberOperations.numberChecker(['a'])).to.throw(Error, 'The input is not a number!');
            });

            it('Object input', ()=>{
                expect(()=>numberOperations.numberChecker({'a': 1})).to.throw(Error, 'The input is not a number!');
            });

            it('Undefined input', ()=>{
                expect(()=>numberOperations.numberChecker(undefined)).to.throw(Error, 'The input is not a number!');
            });
        });

        describe('Testing with numbers less tn 100', ()=>{
            it('les then 100', ()=>{
                expect(numberOperations.numberChecker(2)).to.equal('The number is lower than 100!');
            });

            it('les then 100', ()=>{
                expect(numberOperations.numberChecker(0)).to.equal('The number is lower than 100!');
            });

            it('les then 100', ()=>{
                expect(numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
            });

            it('les then 100', ()=>{
                expect(numberOperations.numberChecker(-1)).to.equal('The number is lower than 100!');
            });
        });

        describe('Testing with numbers bigger tn 100', ()=>{
            it('bigger then 100', ()=>{
                expect(numberOperations.numberChecker(101)).to.equal('The number is greater or equal to 100!');
            });

            it('bigger then 100', ()=>{
                expect(numberOperations.numberChecker(105)).to.equal('The number is greater or equal to 100!');
            });

            it('bigger then 100', ()=>{
                expect(numberOperations.numberChecker(100.1)).to.equal('The number is greater or equal to 100!');
            });

            it('bigger then 100', ()=>{
                expect(numberOperations.numberChecker(150)).to.equal('The number is greater or equal to 100!');
            });
        });

        describe('Edge case', ()=>{
            it('Testing with 100 exact', ()=>{
                expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            });
        })
    });

    describe('Testing the sumArrays func', ()=>{
        describe('Testing with equal length arrays',()=>{
            it('equal length', ()=>{
                expect(numberOperations.sumArrays([1, 1], [0,0])).to.deep.equal([1, 1]);
            });

            it('equal length', ()=>{
                expect(numberOperations.sumArrays([1, 1], [-1,-1])).to.deep.equal([0, 0]);
            });

            it('equal length', ()=>{
                expect(numberOperations.sumArrays([0, 0], [0, 0])).to.deep.equal([0, 0]);
            });

            it('equal length', ()=>{
                expect(numberOperations.sumArrays([-1, -1], [0, 0])).to.deep.equal([-1, -1]);
            });

            it('equal length', ()=>{
                expect(numberOperations.sumArrays([-1, -1], [2, 2])).to.deep.equal([1, 1]);
            });

            it('equal length', ()=>{
                expect(numberOperations.sumArrays([1.2, 1.1], [1.1, 1.5])).to.deep.equal([2.3, 2.6]);
            });
        });

        describe('Testing func with diff array length', ()=>{
            it('diff length', ()=>{
                expect(numberOperations.sumArrays([1, 1 ,1], [1, 1])).to.deep.equal([2, 2, 1]);
            });

            it('diff length', ()=>{
                expect(numberOperations.sumArrays([0, 0 ,1], [1, 1])).to.deep.equal([1, 1, 1]);
            });

            it('diff length', ()=>{
                expect(numberOperations.sumArrays([1, 1 ,1], [2, 2])).to.deep.equal([3, 3, 1]);
            });

            it('diff length', ()=>{
                expect(numberOperations.sumArrays([1, 1 ], [1.2, 1.3, 2.5])).to.deep.equal([2.2, 2.3, 2.5]);
            });
        });
    });
});