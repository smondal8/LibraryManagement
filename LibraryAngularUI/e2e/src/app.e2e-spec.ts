import { AppPage } from './app.po';
import { browser, element, by, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should contain correct title message', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('Welcome to Library Management System!');
  });
  it('should contain correct Table Headers', () => {
    page.navigateTo();    
    expect(page.getTheHeaders()).toContain("Library Code");
  });
  it('should contain correct value in details table', ()=>{
    page.navigateTo();
    element.all(by.tagName('td')).then(function(items) {
      expect(items.length).toBe(6);
      expect(items[0].getText()).toBe('101');
      expect(items[1].getText()).toBe('Mumbai');      
      expect(items[4].getText()).toBe('Bangalore');
      expect(items[3].getText()).toBe('102');      
    });
    
  })
  
  it('should display book details after click of details button', ()=>{
    page.navigateTo();
    element.all(by.tagName('button')).then(function(buttons){
      buttons[2].click();
      element.all(by.css('td')).then(function(items){
        expect(items.length).toBe(9);
        expect(items[6].getText()).toBe('101');
        expect(items[7].getText()).toBe('Java - Complete Reference');
        expect(items[8].getText()).toBe('Herbert Schildt');
      });      
    }); 
    element.all(by.tagName('button')).then(function(buttons){      
      buttons[1].click();
      element.all(by.css('td')).then(function(items){
        expect(items.length).toBe(9);
        expect(items[6].getText()).toBe('100');
        expect(items[7].getText()).toBe('Let us C');
        expect(items[8].getText()).toBe('Yashwanth Kanetkar');
      });    
    });    
  });


  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
