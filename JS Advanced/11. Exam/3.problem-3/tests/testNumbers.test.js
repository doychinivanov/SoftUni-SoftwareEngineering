const {expect} = require('chai');
const testNumbers = require('../testNumbers');

describe('Testing a set of functions', ()=>{
    describe('Testing the sumNumber fun', ()=>{
        describe('Testing the happy path', ()=>{
            it('happy path', ()=>{
                expect(testNumbers.sumNumbers(1, 1)).to.equal('2.00');
            });

            it('happy path', ()=>{
                expect(testNumbers.sumNumbers(0, 0)).to.equal('0.00');
            });

            it('happy path', ()=>{
                expect(testNumbers.sumNumbers(1, -2)).to.equal('-1.00');
            });

            it('happy path', ()=>{
                expect(testNumbers.sumNumbers(-1.5, -2)).to.equal('-3.50');
            });

            it('happy path', ()=>{
                expect(testNumbers.sumNumbers(1.52555, 2)).to.equal('3.53');
            });

            it('happy path', ()=>{
                expect(testNumbers.sumNumbers(1.52255, 2)).to.equal('3.52');
            });
        });

        describe('Testing with wrong input type', ()=>{
            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers(1.52255, 'a')).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers('a', 1.52255)).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers('a', 'a')).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers(['a'], 'a')).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers(['a'], ['a'])).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers({'a': 1}, ['a'])).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers(undefined, 1)).to.be.undefined;
            });

            it('one wrong input', ()=>{
                expect(testNumbers.sumNumbers(null, 1)).to.be.undefined;
            });
        });
    });

    describe('Testing the numberChecker func', ()=>{
        describe('Testing the happy path', ()=>{
            describe('Testing with even number', ()=>{
                it('even', ()=>{
                    expect(testNumbers.numberChecker('2')).to.equal('The number is even!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker(2)).to.equal('The number is even!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker('0')).to.equal('The number is even!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker(0)).to.equal('The number is even!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker('-2')).to.equal('The number is even!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker(-2)).to.equal('The number is even!');
                });
            });

            describe('Testing with odd numbers', ()=>{
                it('even', ()=>{
                    expect(testNumbers.numberChecker('1')).to.equal('The number is odd!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker(1)).to.equal('The number is odd!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker(-1)).to.equal('The number is odd!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker('-1')).to.equal('The number is odd!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker('5')).to.equal('The number is odd!');
                });

                it('even', ()=>{
                    expect(testNumbers.numberChecker('3')).to.equal('The number is odd!');
                });
            });
        });

        describe('Testing with wrong input type', ()=>{
            it('wrong', ()=>{
                expect(()=>testNumbers.numberChecker('a')).to.throw(Error, 'The input is not a number!');
            });

            it('wrong', ()=>{
                expect(()=>testNumbers.numberChecker(['s'])).to.throw(Error, 'The input is not a number!');
            });

            it('wrong', ()=>{
                expect(()=>testNumbers.numberChecker({'a': 1})).to.throw(Error, 'The input is not a number!');
            });

            it('wrong', ()=>{
                expect(()=>testNumbers.numberChecker(undefined)).to.throw(Error, 'The input is not a number!');
            });
        });
    });

    describe('Testing the avg of array', ()=>{
        it('some arr test', ()=>{
            expect(testNumbers.averageSumArray([1, 1, 1])).to.equal(1);
        });

        it('some arr test', ()=>{
            expect(testNumbers.averageSumArray([-1, -1, -1])).to.equal(-1);
        });

        it('some arr test', ()=>{
            expect(testNumbers.averageSumArray([0, 0, 0])).to.equal(0);
        });

        it('some arr test', ()=>{
            expect(testNumbers.averageSumArray([1, 2, 3])).to.equal(2);
        });
    });
});