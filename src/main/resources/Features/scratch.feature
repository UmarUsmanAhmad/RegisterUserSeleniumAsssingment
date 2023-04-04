Feature:

  Scenario Outline:UserRegister

    Given Open the Website"<WebBrowser>"
    And Write Email"<Email>"
    And Choose UserName"<Username>"
    And Write Password"<Password>"
    And Click on accept privacy and terms
    When click on "<SignUp>"
    Then User will be Registered"<Created>"
    Examples:
      | WebBrowser | Email                   | Username                                                                                                             | Password     | Created |
      | Chrome     | umar.123456728@mail.com | UmAr1234511393449                                                                                                    | Umar000123.A | Yes     |
      | Chrome     | umar.123456728@mail.com | UmAr1234511393449                                                                                                    | Umar000123.A | No      |
      | Edge       | umar.12345678@mail.com  | UmAr1234567013448                                                                                                    | Umar000123.A | yes     |
      | Edge       | umar.12345678@mail.com  | UmAr1234567013448                                                                                                    | Umar000123.A | No      |
      | Chrome     | umar.12345678@gmail.com | ummar01234Ummar02asdasdasd1234Ummar01234Ummar01234Ummar01234Ummar01234Ummar01234Ummar01234Ummar01234Ummar01242asdasd | Umar000123.A | NO      |
      | Edge       | umar.12345678@mail.com  | umar950000umar9540000umar950000umar950000umar950000umar950000umar950000umar950000umar950000umar950044kuaskjasslkjas  | Umar000123.A | No      |


  Scenario Outline:NoEmail

    Given Open the Website"<WebBrowser>"
    And Write Email"<Email>"
    And Choose UserName"<Username>"
    And Write Password"<Password>"
    And Click on accept privacy and terms
    When click on "<SignUp>"
    Then User without Email Cannot be Registered"<Created>"

    Examples:
      | WebBrowser | Email | Username  | Password     | Created |
      | Chrome     |       | umar94231 | Umar000123.A | No      |
      | Edge       |       | UmAr94901 | Umar000123.A | No      |




