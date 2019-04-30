@Api @Regression
Feature: As a user of ITS make API call

  Scenario: Execute get API call and verify all required records
    Given Configure GET "users" api call
    Then Execute api with expected 200 response code
    Then Verify response records should contains details
      | ID | NAME                 | EMAIL                     | PHONE                 |
      |  1 | Leanne Graham        | Sincere@april.biz         | 1-770-736-8031 x56442 |
      |  2 | Ervin Howell         | Shanna@melissa.tv         | 010-692-6593 x09125   |
      |  3 | Clementine Bauch     | Nathan@yesenia.net        | 1-463-123-4447        |
      |  4 | Patricia Lebsack     | Julianne.OConner@kory.org | 493-170-9623 x156     |
      |  5 | Chelsey Dietrich     | Lucio_Hettinger@annie.ca  | (254)954-1289         |
      |  6 | Mrs. Dennis Schulist | Karley_Dach@jasper.info   | 1-477-935-8478 x6430  |
