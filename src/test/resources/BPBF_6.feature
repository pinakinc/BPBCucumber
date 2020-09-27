#Sample Feature Definition Template
@FunctionalSuite
Feature: Title of your feature
  I want to use this template for my feature file

  @Smoke
  Scenario: Smoke Test 1
    Given I want to execute "Smoke Test 1" test

  @FilterTest
  Scenario: Filter Test 1
    Given I want to execute "Filter Test 1" test
    
  @Regression
  Scenario: Regression Test 1
    Given I want to execute "Regression Test 1" test
    
  @Smoke @FilterTest
  Scenario: Smoke/Filter Test 1
    Given I want to execute "Smoke/Filter Test 1" test
    
  @Smoke @Regression
  Scenario: Smoke/Regression Test 1
    Given I want to execute "Smoke/Regression" test
  
    
      @Regression @FilterTest
  Scenario: Regression/Filter Test 1
    Given I want to execute "Regression/Filter Test 1" test
    
      
  Scenario: Generic Test 1
    Given I want to execute "Generic" test
    
