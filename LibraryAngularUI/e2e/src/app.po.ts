import { browser, by, element } from 'protractor';

export class AppPage {
  gettableCoulmn() {
    return element(by.tagName('td')).last() as Promise<any>;
  }
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('app-root h1')).getText() as Promise<string>;
  }

  getTheHeaders() {
    return element(by.tagName('th')).getText() as Promise<string>;
  }
}
