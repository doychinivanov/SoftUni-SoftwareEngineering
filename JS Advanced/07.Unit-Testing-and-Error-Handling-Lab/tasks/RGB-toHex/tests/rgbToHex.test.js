const { expect } = require('chai');
const rgbToHexColor = require('../rgbToHex');


describe('Testing rgbToHex funciton', ()=>{
    describe('Testing the happy path', ()=>{
        describe('Tesing conventional colors', ()=>{
            it('Testing white', ()=>{
                expect(rgbToHexColor(255, 255, 255)).to.equal('#FFFFFF');
            });

            it('Testing black', ()=>{
                expect(rgbToHexColor(0, 0, 0)).to.equal('#000000');
            });

            it('Testing red', ()=>{
                expect(rgbToHexColor(255, 0, 0)).to.equal('#FF0000');
            });
        });

        describe('Test overload', ()=>{
            it('Testing yellow', ()=>{
                expect(rgbToHexColor(255, 255, 0)).to.equal('#FFFF00');
            });

            it('Testing navy', ()=>{
                expect(rgbToHexColor(0, 0, 128)).to.equal('#000080');
            });

            it('Testing pink', ()=>{
                expect(rgbToHexColor(255, 0, 255)).to.equal('#FF00FF');
            });

            it('Testing aqua', ()=>{
                expect(rgbToHexColor(0, 255, 255)).to.equal('#00FFFF');
            });
        })
    });

    describe('Testing invalid input arguments', ()=>{
        describe('Testing invalid type', ()=>{
            it('string input', ()=>{
                expect(rgbToHexColor('a', 1, 1)).to.be.undefined;
            });

            it('string input', ()=>{
                expect(rgbToHexColor(1, 'a', 1)).to.be.undefined;
            });

            it('string input', ()=>{
                expect(rgbToHexColor(1, 1, 'a')).to.be.undefined;
            });

            it('array input', ()=>{
                expect(rgbToHexColor(1, 1, [1])).to.be.undefined;
            });

        });

        describe('Testing arguments out of range', ()=>{
            it('First argument is out of range', ()=>{
                expect(rgbToHexColor(256, 1, 1)).to.be.undefined;
            });

            it('Second argument is out of range', ()=>{
                expect(rgbToHexColor(1, 256, 1)).to.be.undefined;
            });

            it('Third argument is out of range', ()=>{
                expect(rgbToHexColor(1, 1, 256)).to.be.undefined;
            });

            it('negative argument', ()=>{
                expect(rgbToHexColor(1, 1, -1)).to.be.undefined;
            });
        })
    });
})