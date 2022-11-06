import { cyan } from "color-name"
import { AssertionError } from "assert"

/*
Task #4
Write down a simple integration test to the task #3 you did before.
No need to check all the data retrieved by the button pushing. Just a Company name would be enough !
*/
describe('Test to be fulfilled by the candidate', () => {
  it('push the button implemented on task #3 and shows the company names', () => {
      cy.visit('http://localhost:4200')
      cy.get('button').should('contain','GET COMPANIES')
      cy.get('span').should('contain','Tiago Luiz Morais')
      cy.get('#request').click()
      cy.get('td').should('contain','Ford')
      cy.get('td').should('contain','Poucelle')
      cy.get('td').should('contain','Ifood')
      cy.get('td').should('contain','vehicles')
      cy.get('td').should('contain','handbags')
      cy.get('td').should('contain','food')
  })
})
