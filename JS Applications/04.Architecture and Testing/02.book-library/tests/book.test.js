const { chromium } = require('playwright-chromium');
const { expect } = require('chai');

let browser
let page;

describe('End to end tests for booklibrary app', function () {
    this.timeout(10000);

    before(async () => { browser = await chromium.launch({headless: false, slowMo: 1000}); });

    after(async () => { await browser.close(); });

    beforeEach(async () => { page = await browser.newPage(); });

    afterEach(async () => { await page.close(); });

    describe('Testing loading books', () => {
        it('loads hardcoded msg', async () => {
            await page.goto('http://localhost:3000');
            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');

            await page.waitForSelector('tbody');
            const content = await page.$eval('tbody', tbody=>tbody.innerHTML);
            expect(content).to.include('Harry Potter and the Philosopher\'s Stone');
            expect(content).to.include('J.K.Rowling');
            expect(content).to.include('C# Fundamentals');
            expect(content).to.include('Svetlin Nakov');

        });
    });

    describe('Testing creating a book', ()=>{
        it('creates a book', async ()=>{
            const author = 'gosho';
            const title = 'Test book';

            await page.goto('http://localhost:3000');
            await page.waitForSelector('#createForm');

            await page.fill('[name="author"]', author),
            await page.fill('[name="title"]', title)

            await page.click('text=Submit');

            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');


            const content = await page.$eval('tbody', tbody=>tbody.innerHTML);
            expect(content).to.include(author);
            expect(content).to.include(title);

        })
    });

    describe('Testing editing a book', ()=>{
        it('edites a book', async ()=>{
            const author = 'sasho';
            const title = 'sasho book';

            await page.goto('http://localhost:3000');
            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');

            await page.click(':nth-match(:text("Edit"), 1)');

            await page.waitForSelector('#editForm');


            await page.$eval('#editForm input[name="author"]', input=>input.value = 'sasho');
            await page.$eval('#editForm input[name="title"]', input=>input.value = 'sasho book');

            await page.click('text=Save');

            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');


            const content = await page.$eval('tbody', tbody=>tbody.innerHTML);
            expect(content).to.include(author);
            expect(content).to.include(title);

        });

        it('edites a book', async ()=>{
            const author = 'pesho3';
            const title = 'pesho3 book';

            await page.goto('http://localhost:3000');
            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');

            await page.click(':nth-match(:text("Edit"), 2)');

            await page.waitForSelector('#editForm');


            await page.$eval('#editForm input[name="author"]', input=>input.value = 'pesho3');
            await page.$eval('#editForm input[name="title"]', input=>input.value = 'pesho3 book');

            await page.click('text=Save');

            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');


            const content = await page.$eval('tbody', tbody=>tbody.innerHTML);
            expect(content).to.include(author);
            expect(content).to.include(title);

        })
    });

    describe('Testing deleting a book', ()=>{
        it('deletes a book', async ()=>{
            const author = 'sasho';
            const title = 'sasho book';

            await page.goto('http://localhost:3000');
            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');
            
            page.on("dialog", dialog => dialog.accept())
            await page.click(':nth-match(:text("Delete"), 1)');

            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');


            const content = await page.$eval('tbody', tbody=>tbody.innerHTML);
            expect(content).not.to.include(author);
            expect(content).not.to.include(title);

        });

        it('deletes a book', async ()=>{
            const author = 'pesho3';
            const title = 'pesho3 book';

            await page.goto('http://localhost:3000');
            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');
            
            page.on("dialog", dialog => dialog.accept())
            await page.click(':nth-match(:text("Delete"), 1)');

            await page.waitForSelector('#loadBooks');
            await page.click('#loadBooks');


            const content = await page.$eval('tbody', tbody=>tbody.innerHTML);
            expect(content).not.to.include(author);
            expect(content).not.to.include(title);

        });
    });
});