const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

let browser
let page;

describe('End to end tests for messanger app', function () {
    this.timeout(20000);

    before(async () => { browser = await chromium.launch(); });

    after(async () => { await browser.close(); });

    beforeEach(async () => { page = await browser.newPage(); });

    afterEach(async () => { await page.close(); });

    describe('Testing loading messages', () => {
        const hardCodedMsg = ['Spami: Hello, are you there?','Garry: Yep, whats up :?','Spami: How are you? Long time no see? :)', 'George: Hello, guys! :))', 'Spami: Hello, George nice to see you! :)))']
        it('loads hardcoded msg', async () => {
            await page.goto('http://localhost:3000/');
            await page.waitForSelector('#controls');
            await page.click('#refresh');

            await page.waitForSelector('textarea');
            const content = await page.$$eval('textarea', areas => areas.map(area => area.value));
            expect(content[0].split('\n')[0]).to.equal(hardCodedMsg[0]);
            expect(content[0].split('\n')[1]).to.equal(hardCodedMsg[1]);
            expect(content[0].split('\n')[2]).to.equal(hardCodedMsg[2]);
            expect(content[0].split('\n')[3]).to.equal(hardCodedMsg[3]);
            expect(content[0].split('\n')[4]).to.equal(hardCodedMsg[4]);
        });
    });

    describe('Testing creating msg', ()=>{
        it('sends a msg', async ()=>{
            const author = 'gosho';
            const message = 'I am a message from playwright';

            await page.goto('http://localhost:3000/');
            await page.waitForSelector('#controls');

            await page.fill('[id="author"]', author),
            await page.fill('[id="content"]', message)

            await page.click('#submit');

            await page.click('#refresh');

            await page.waitForSelector('textarea');
            const content = await page.$$eval('textarea', areas => areas.map(area => area.value));
            expect(content[0].split('\n').pop()).to.equal(`${author}: ${message}`);

        })
    });
});