const {expect} = require('chai');
const mathEnforcer = require('../mathEnforcer');

describe('Testing functions addFive, subtractTen and sum', ()=>{
    describe('Testing the addFive function', ()=>{
        describe('Testing the happy path', ()=>{
            describe('Testing for positive numbers', ()=>{
                it('testing positive numbers',()=>{
                    expect(mathEnforcer.addFive(1)).to.equal(6);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.addFive(0)).to.equal(5);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.addFive(2)).to.equal(7);
                });
            });

            describe('Testing for negative numbers', ()=>{
                it('testing negative numbers',()=>{
                    expect(mathEnforcer.addFive(-1)).to.equal(4);
                });

                it('testing negative numbers',()=>{
                    expect(mathEnforcer.addFive(-5)).to.equal(0);
                });

                it('testing negative numbers',()=>{
                    expect(mathEnforcer.addFive(-10)).to.equal(-5);
                });
            });

            describe('Testing for floating numbers', ()=>{
                it('testing floating numbers',()=>{
                    expect(mathEnforcer.addFive(1.1)).to.be.closeTo(6.1, 0.01);
                });

                it('testing floating numbers',()=>{
                    expect(mathEnforcer.addFive(0.01)).to.be.closeTo(5.00, 0.01);
                });

                it('testing floating numbers',()=>{
                    expect(mathEnforcer.addFive(-5.01)).to.be.closeTo(0.00, 0.01);
                });
            });

        });

        describe('Testing invalid type input', ()=>{
            it('invalid input', ()=>{
                expect(mathEnforcer.addFive('a')).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.addFive([1])).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.addFive({x:1})).to.be.undefined;
            });
        });
    });

    describe('Testing the subtractTen function', ()=>{
        describe('Testing the happy path', ()=>{
            describe('Testing for positive numbers', ()=>{
                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(1)).to.equal(-9);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(0)).to.equal(-10);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(10)).to.equal(0);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(11)).to.equal(1);
                });
            });

            describe('Testing for negative numbers', ()=>{
                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(-1)).to.equal(-11);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(-5)).to.equal(-15);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.subtractTen(-11)).to.equal(-21);
                });
            });

            describe('Testing for floating numbers', ()=>{
                it('testing floating numbers',()=>{
                    expect(mathEnforcer.subtractTen(1.1)).to.be.closeTo(-8.9, 0.01);
                });

                it('testing floating numbers',()=>{
                    expect(mathEnforcer.subtractTen(10.01)).to.be.closeTo(0.01, 0.01);
                });

                it('testing floating numbers',()=>{
                    expect(mathEnforcer.subtractTen(-5.01)).to.be.closeTo(-15.01, 0.01);
                });
            });

        });

        describe('Testing invalid type input', ()=>{
            it('invalid input', ()=>{
                expect(mathEnforcer.subtractTen('a')).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.subtractTen([1])).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.subtractTen({x:1})).to.be.undefined;
            });
        });
    });

    describe('Testing the sum function', ()=>{
        describe('Testing the happy path', ()=>{
            describe('Testing for integers numbers', ()=>{
                it('testing positive and negative integer numbers',()=>{
                    expect(mathEnforcer.sum(1, 1)).to.equal(2);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.sum(0, -1)).to.equal(-1);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.sum(10, -10)).to.equal(0);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.sum(11, -1)).to.equal(10);
                });
            });

            describe('Testing for floating numbers', ()=>{
                it('testing positive and negative integer numbers',()=>{
                    expect(mathEnforcer.sum(1.1, 1)).to.be.closeTo(2.1, 0.01);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.sum(0, -1.1)).to.be.closeTo(-1.1, 0.01);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.sum(10, -10)).to.equal(0.00, 0.01);
                });

                it('testing positive numbers',()=>{
                    expect(mathEnforcer.sum(11, -1)).to.equal(10.00, 0.01);
                });
            });

        });

        describe('Testing invalid type input', ()=>{
            it('invalid input', ()=>{
                expect(mathEnforcer.sum('a', 1)).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum([1], 1)).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum({x:1}, 1)).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum(1, '1')).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum(1, ['1'])).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum(1, {x:1})).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum('1', '1')).to.be.undefined;
            });

            it('invalid input', ()=>{
                expect(mathEnforcer.sum([1], '1')).to.be.undefined;
            });
        });
    });
});